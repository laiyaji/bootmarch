package spring.boot.example.bootmarch.domain;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SSCData implements Serializable {

	private static final long serialVersionUID = 100L;
	// 0-23期共中期数
	private String for_0to_23;
	// 24-120期共中期数
	private String for_24to_120;
	// 创建时间
	private String create_date;
	// 期号 如:20180710001-20180710120
	private String date_order;
	// 出奖号码
	private String number;
	// 批量新增数据
	private String jsonString;

	// 万~个位 单号位置 大-小
	private String wan_bigSmall;
	private String qian_bigSmall;
	private String bai_bigSmall;
	private String shi_bigSmall;
	private String ge_bigSmall;

	// 万~个位 单号码
	private String wan;
	private String qian;
	private String bai;
	private String shi;
	private String ge;

	// 万~个位 最大连挂期数
	private String guawan;
	private String guaqian;
	private String guabai;
	private String guashi;
	private String guage;

	// 万~个位 共中期数
	private String gzwan;
	private String gzqian;
	private String gzbai;
	private String gzshi;
	private String gzge;

	// 标记是那个位置，万:ssc_wan，千:ssc_qian，百:ssc_bai，十:ssc_shi，个:ssc_ge
	private String table_name;
	
	private String max_lianxu_buchu;
	
	public String getMax_lianxu_buchu() {
		return max_lianxu_buchu;
	}

	public void setMax_lianxu_buchu(String max_lianxu_buchu) {
		this.max_lianxu_buchu = max_lianxu_buchu;
	}

	public String getGuawan() {
		return guawan;
	}

	public void setGuawan(String guawan) {
		this.guawan = guawan;
	}

	public String getGuaqian() {
		return guaqian;
	}

	public void setGuaqian(String guaqian) {
		this.guaqian = guaqian;
	}

	public String getGuabai() {
		return guabai;
	}

	public void setGuabai(String guabai) {
		this.guabai = guabai;
	}

	public String getGuashi() {
		return guashi;
	}

	public void setGuashi(String guashi) {
		this.guashi = guashi;
	}

	public String getGuage() {
		return guage;
	}

	public void setGuage(String guage) {
		this.guage = guage;
	}

	public String getGzwan() {
		return gzwan;
	}

	public void setGzwan(String gzwan) {
		this.gzwan = gzwan;
	}

	public String getGzqian() {
		return gzqian;
	}

	public void setGzqian(String gzqian) {
		this.gzqian = gzqian;
	}

	public String getGzbai() {
		return gzbai;
	}

	public void setGzbai(String gzbai) {
		this.gzbai = gzbai;
	}

	public String getGzshi() {
		return gzshi;
	}

	public void setGzshi(String gzshi) {
		this.gzshi = gzshi;
	}

	public String getGzge() {
		return gzge;
	}

	public void setGzge(String gzge) {
		this.gzge = gzge;
	}

	public String getWan_bigSmall() {
		return wan_bigSmall;
	}

	public void setWan_bigSmall(String wan_bigSmall) {
		this.wan_bigSmall = wan_bigSmall;
	}

	public String getQian_bigSmall() {
		return qian_bigSmall;
	}

	public void setQian_bigSmall(String qian_bigSmall) {
		this.qian_bigSmall = qian_bigSmall;
	}

	public String getBai_bigSmall() {
		return bai_bigSmall;
	}

	public void setBai_bigSmall(String bai_bigSmall) {
		this.bai_bigSmall = bai_bigSmall;
	}

	public String getShi_bigSmall() {
		return shi_bigSmall;
	}

	public void setShi_bigSmall(String shi_bigSmall) {
		this.shi_bigSmall = shi_bigSmall;
	}

	public String getGe_bigSmall() {
		return ge_bigSmall;
	}

	public void setGe_bigSmall(String ge_bigSmall) {
		this.ge_bigSmall = ge_bigSmall;
	}

	public String getWan() {
		return wan;
	}

	public void setWan(String wan) {
		this.wan = wan;
	}

	public String getQian() {
		return qian;
	}

	public void setQian(String qian) {
		this.qian = qian;
	}

	public String getBai() {
		return bai;
	}

	public void setBai(String bai) {
		this.bai = bai;
	}

	public String getShi() {
		return shi;
	}

	public void setShi(String shi) {
		this.shi = shi;
	}

	public String getGe() {
		return ge;
	}

	public void setGe(String ge) {
		this.ge = ge;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public String getDate_order() {
		return date_order;
	}

	public void setDate_order(String date_order) {
		this.date_order = date_order;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getFor_0to_23() {
		return for_0to_23;
	}

	public void setFor_0to_23(String for_0to_23) {
		this.for_0to_23 = for_0to_23;
	}

	public String getFor_24to_120() {
		return for_24to_120;
	}

	public void setFor_24to_120(String for_24to_120) {
		this.for_24to_120 = for_24to_120;
	}

}
