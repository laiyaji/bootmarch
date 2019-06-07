package spring.boot.example.bootmarch.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spring.boot.example.bootmarch.domain.PK10Data;
import spring.boot.example.bootmarch.domain.SSCData;
import spring.boot.example.bootmarch.domain.User;
import spring.boot.example.bootmarch.jdbc.dao.ExportForExcelDao;
import spring.boot.example.bootmarch.jdbc.service.JdbcUserService;
import spring.boot.example.bootmarch.service.SSCDataService;

@RestController
public class UserController {
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private SSCDataService sscDataService;

	@Autowired
	private JdbcUserService jdbcUserService;

	@Autowired
	private ExportForExcelDao exportForExcelDao;

	/**
	 * 查询数据集合
	 * 
	 * @return
	 */
	@RequestMapping("findSSCList")
	public Map<String, Object> findSSCList(SSCData ssc) {
		Map<String, Object> lineMap = new HashMap<String, Object>();
		if (logger.isDebugEnabled()) {
			logger.info("logback 成功了==findSSCList");
			logger.info(ssc.getTable_name());
		}
		List<String> timeList = new ArrayList<String>();
		List<String> value23List = new ArrayList<String>();
		List<String> value120List = new ArrayList<String>();
		List<SSCData> userList = sscDataService.findSSCList(ssc);
		for (SSCData sscData : userList) {
			timeList.add(sscData.getCreate_date());
			value23List.add(sscData.getFor_0to_23());
			value120List.add(sscData.getFor_24to_120());
		}
		lineMap.put("timeList", timeList);
		lineMap.put("value23List", value23List);
		lineMap.put("value120List", value120List);
		return lineMap;
	}

	/**
	 * 查询数据集合
	 * 
	 * @return
	 */
	@RequestMapping("findPK10History")
	public List<PK10Data> findPK10History(PK10Data ssc) {
		List<PK10Data> list = sscDataService.findPK10History(ssc);
		return list;

	}
	/**
	 * 查询数据集合
	 * 
	 * @return
	 */
	@RequestMapping("findSSCHistoryList")
	public List<SSCData> findSSCHistoryList(SSCData ssc) {
		List<SSCData> list = sscDataService.findSSCHistoryList(ssc);
		return list;
		
	}

	@RequestMapping(value = "addSscData", method = RequestMethod.POST)
	public String addSscData(SSCData ssc) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String msg = "N";
		int count = 0;
		try {
			SSCData sscData = mapper.readValue(ssc.getJsonString(), SSCData.class);
			count = sscDataService.addSSCData(sscData);
			if (count == 1) {
				msg = "Y";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
			return msg;
		

	}
	
	/**
	 * 北京赛车批量新增
	 * @param pk10
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "addPK10Batch", method = RequestMethod.POST)
	public String addPK10Batch(PK10Data pk10) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		List<PK10Data> resultList = mapper.readValue(pk10.getJsonString(), new TypeReference<List<PK10Data>>() {
		});
		sscDataService.addPK10Batch(resultList);
		return "Y";
		
	}

	/**
	 * 批量新增
	 * 
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping("addSSCHistory")
	public String addSSCHistory(SSCData ssc) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		List<SSCData> resultList = mapper.readValue(ssc.getJsonString(), new TypeReference<List<SSCData>>() {
		});
		sscDataService.addBatchSSCHistory(resultList);
		return "Y";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * jdbc查询数据动处理ResultSet结果集
	 * 
	 * @return
	 */
	@RequestMapping("findUserListTypeJdbc")
	public List<User> findUserListTypeJdbc() {
		if (logger.isDebugEnabled()) {
			logger.info("logback 成功了==findUserListTypeJdbc");
		}
		List<User> userList = jdbcUserService.findUserList();
		return userList;
	}

	/**
	 * 单行数据新增
	 * 
	 * @param user
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public int addUser(@RequestBody SSCData ssc) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		if (logger.isDebugEnabled()) {
			logger.info("logback 成功了==addUser");
			logger.info("addUser RequestParam User==" + mapper.writeValueAsString(ssc));
		}

		return sscDataService.addSSCData(ssc);
	}

	/**
	 * jdbc手动写SQL新增数据行
	 * 
	 * @param user
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "addUserTypeJdbc", method = RequestMethod.POST)
	public int addUserTypeJdbc(@RequestBody User user) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		// 为空不显示
		mapper.setSerializationInclusion(Include.NON_NULL);
		// 忽略不匹配的字段
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		if (logger.isDebugEnabled()) {
			logger.info("logback 成功了==addUserTypeJdbc");
			logger.info("addUserTypeJdbc RequestParam User==" + mapper.writeValueAsString(user));
		}

		return jdbcUserService.addUser(user);
	}

	/**
	 * 导出Excel表格
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "exportForExcelForUsers")
	public void exportForExcelForUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<String> columnList = new ArrayList<String>();
		List<String> headerList = new ArrayList<String>();

		columnList.add("user_id");
		columnList.add("user_name");
		columnList.add("user_phone");
		columnList.add("score");
		columnList.add("create_time");

		headerList.add("商户编号");
		headerList.add("商户名称");
		headerList.add("商户电话");
		headerList.add("商户评分");
		headerList.add("加盟时间");

		String listName = "用户列表信息";

		String exportName = URLEncoder.encode(listName, "UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition", "attachment;filename=\"" + exportName + ".xls\"");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("columnList", columnList);
		map.put("headerList", headerList);
		map.put("response", response);

		exportForExcelDao.exportDataForExcel(map);
	}

}
