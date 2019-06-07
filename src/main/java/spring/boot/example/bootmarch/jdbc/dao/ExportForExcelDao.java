package spring.boot.example.bootmarch.jdbc.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.boot.example.bootmarch.domain.User;

@Repository("exportForExcelDao")
public class ExportForExcelDao {
	private final static Logger logger = LoggerFactory.getLogger(ExportForExcelDao.class);
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	public void exportDataForExcel(Map<String, Object> map) throws IOException {
			String queryUserCount="select count(1) count from _user";
		 
			final int total=jdbcTemplate.queryForObject(queryUserCount, new RowMapper<Integer>(){
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				logger.info("rs.getMetaData().getColumnCount():"+rs.getMetaData().getColumnCount());
				
				return rs.getInt(1) ;
			}
		});
			
		 HttpServletResponse response=(HttpServletResponse)map.get("response");
		 final PrintWriter out = response.getWriter();
		 
		 if(total>0) {
			 
			 final int responseCount = 1000;
			 @SuppressWarnings("unchecked")
			 List<String> columnList=(List<String>)map.get("columnList");
			 @SuppressWarnings("unchecked")
			 List<String> headerList=(List<String>)map.get("headerList");
			 
			 StringBuilder str = new StringBuilder();
			 // excel中文标题行
			 String curDate="2018-04-07";
			 str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><?mso-application progid=\"Excel.Sheet\"?><Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:x=\"urn:schemas-microsoft-com:office:excel\" xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\" xmlns:html=\"http://www.w3.org/TR/REC-html40\"> <DocumentProperties xmlns=\"urn:schemas-microsoft-com:office:office\">  <Author>xingsl</Author>  <LastAuthor>xingsl</LastAuthor>  <Created>"+curDate+"</Created> <LastSaved>"+curDate+"</LastSaved>  <Version>12.00</Version> </DocumentProperties> <ExcelWorkbook xmlns=\"urn:schemas-microsoft-com:office:excel\">  <WindowHeight>9150</WindowHeight>  <WindowWidth>14940</WindowWidth>  <WindowTopX>360</WindowTopX>  <WindowTopY>270</WindowTopY>  <ProtectStructure>False</ProtectStructure>  <ProtectWindows>False</ProtectWindows> </ExcelWorkbook> <Styles>  <Style ss:ID=\"Default\" ss:Name=\"Normal\">   <Alignment ss:Vertical=\"Bottom\"/>   <Borders/>   <Font ss:FontName=\"Arial\" x:Family=\"Swiss\"/>   <Interior/>   <NumberFormat/>   <Protection/>  </Style> </Styles> <Worksheet ss:Name=\"sheet1\"> <Table ss:ExpandedColumnCount=\""+columnList.size()+"\" ss:ExpandedRowCount=\"");
			 str.append((total + 2));
			 
	         str.append("\" x:FullColumns=\"1\"   x:FullRows=\"1\">   <Row>  ") ;
	         for(int i=0;i<headerList.size();i++){
	              str.append("<Cell><Data ss:Type=\"String\">"+headerList.get(i)+"</Data></Cell>");
	           }
	           str.append("</Row>");
	           
	          // 输出header
	           out.write(str.toString());
	           
	           long start=System.currentTimeMillis(); //获取开始时间
	          // 查询数据填充到表格中
	         String sql="select * from _user";
			 jdbcTemplate.query(sql, new RowMapper<User>(){
				 private int curNum = 0;
                 StringBuilder sb = new StringBuilder();
                 
					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						logger.info("rs.getMetaData().getColumnCount():"+rs.getMetaData().getColumnCount());
						curNum++; 
						
						// 当前记录
						buildRow(rs,sb,columnList);
						
						if (curNum % responseCount == 0|| curNum == total) {
                            // 每sheetCount条写入客户端
							logger.info("curNum:"+curNum);
							logger.info("curNum % responseCount:"+curNum % responseCount);
                             out.write(sb.toString());
                             sb = null;
                             sb = new StringBuilder();
                         }
						return null;
					}
				});
			 
			// 输出footer
	           String foot = " </Table>  <WorksheetOptions xmlns=\"urn:schemas-microsoft-com:office:excel\">   <Print>    <FitWidth>0</FitWidth>    <FitHeight>0</FitHeight>    <ValidPrinterInfo/>   <PaperSizeIndex>9</PaperSizeIndex>    <HorizontalResolution>300</HorizontalResolution>    <VerticalResolution>300</VerticalResolution>   </Print>   <Selected/>   <ProtectObjects>False</ProtectObjects>   <ProtectScenarios>False</ProtectScenarios>  </WorksheetOptions> </Worksheet>  " +

	          "<Worksheet ss:Name=\"Sheet2\">  <Table ss:ExpandedColumnCount=\"0\" ss:ExpandedRowCount=\"0\" x:FullColumns=\"1\"   x:FullRows=\"1\" ss:DefaultColumnWidth=\"54\" ss:DefaultRowHeight=\"14.25\"/> <WorksheetOptions xmlns=\"urn:schemas-microsoft-com:office:excel\">   <ProtectObjects>False</ProtectObjects>   <ProtectScenarios>False</ProtectScenarios>  </WorksheetOptions> </Worksheet> <Worksheet ss:Name=\"Sheet3\">  <Table ss:ExpandedColumnCount=\"0\" ss:ExpandedRowCount=\"0\" x:FullColumns=\"1\"   x:FullRows=\"1\" ss:DefaultColumnWidth=\"54\" ss:DefaultRowHeight=\"14.25\"/>  <WorksheetOptions xmlns=\"urn:schemas-microsoft-com:office:excel\">   <ProtectObjects>False</ProtectObjects>   <ProtectScenarios>False</ProtectScenarios> </WorksheetOptions> </Worksheet></Workbook>";

	           out.write(foot);

	          long end=System.currentTimeMillis(); //获取结束时间

	           out.close();

	           logger.info("总耗时毫秒=:=:=:=:"+(end-start));
		 }
		
	}
	
	 private void buildRow(ResultSet rs, StringBuilder sb,List<String> columnList) throws SQLException {

	       sb.append("<Row>");

	       for (String col : columnList) {

	           sb.append("<Cell><Data ss:Type=\"String\">").append(rs.getString(col)).append("</Data></Cell>\r\n");//1
	       }
	       sb.append("</Row>");
	    }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	   /*
	    * 数据类型格式化在这里处理
	    * public void buildRow(Map<String, Object> map, StringBuilder sb,List<String> key,List<String> type) {

	       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	       sb.append("<Row>");

	      for(int i=0;i<key.size();i++){

	          if("NUM".equals(type.get(i))){

	              sb.append("<Cell><Data ss:Type=\"Number\">").append(

	                     map.get(key.get(i))==null?"":Double.parseDouble(map.get(key.get(i)).toString())).append(

	                    "</Data></Cell>\r\n");//1

	           }else if("DATE".equals(type.get(i))){

	              sb.append("<Cell><Data ss:Type=\"DateTime\">").append(map.get(key.get(i))==null?"":sdf.format(new Date())).append("</Data></Cell>\r\n");//1

	           }else{

	              sb.append("<Cell><Data ss:Type=\"String\">").append(map.get(key.get(i))==null?"":map.get(key.get(i))).append("</Data></Cell>\r\n");//1

	           }

	          

	       }

	       sb.append("</Row>");

	    }*/
	
}
