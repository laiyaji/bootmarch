package spring.boot.example.bootmarch.domain;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PK10Data implements Serializable{
	private static final long serialVersionUID = 101L;
	
		// 期号 如:20180710001-201807101179
		private String pk10_date_order;
		// 出奖号码
		private String pk10_number;
		// 批量新增数据
		private String jsonString;

		// 1名~10名 单号位置 大-小
		private String one_bigSmall;
		private String one_jiOu;
		private String two_bigSmall;
		private String two_jiOu;
		private String three_bigSmall;
		private String three_jiOu;
		private String four_bigSmall;
		private String four_jiOu;
		private String five_bigSmall;
		private String five_jiOu;
		private String six_bigSmall;
		private String six_jiOu;
		private String seven_bigSmall;
		private String seven_jiOu;
		private String eight_bigSmall;
		private String eight_jiOu;
		private String nine_bigSmall;
		private String nine_jiOu;
		private String ten_bigSmall;
		private String ten_jiOu;

		// 1名~10名 单号码
		private String one;
		private String two;
		private String three;
		private String four;
		private String five;
		private String six;
		private String seven;
		private String eight;
		private String nine;
		private String ten;

		// 1名~10名 最大连挂期数
		private String gone;
		private String gtwo;
		private String gthree;
		private String gfour;
		private String gfive;
		private String gsix;
		private String gseven;
		private String geight;
		private String gnine;
		private String gten;

		// 1名~10名 共中期数
		private String zone;
		private String ztwo;
		private String zthree;
		private String zfour;
		private String zfive;
		private String zsix;
		private String zseven;
		private String zeight;
		private String znine;
		private String zten;
		
		// 期号
		private String start;
		private String ent;
		
		public String getStart() {
			return start;
		}
		public void setStart(String start) {
			this.start = start;
		}
		public String getEnt() {
			return ent;
		}
		public void setEnt(String ent) {
			this.ent = ent;
		}
		public String getPk10_date_order() {
			return pk10_date_order;
		}
		public void setPk10_date_order(String pk10_date_order) {
			this.pk10_date_order = pk10_date_order;
		}
		public String getPk10_number() {
			return pk10_number;
		}
		public void setPk10_number(String pk10_number) {
			this.pk10_number = pk10_number;
		}
		public String getJsonString() {
			return jsonString;
		}
		public void setJsonString(String jsonString) {
			this.jsonString = jsonString;
		}
		public String getOne_bigSmall() {
			return one_bigSmall;
		}
		public void setOne_bigSmall(String one_bigSmall) {
			this.one_bigSmall = one_bigSmall;
		}
		public String getTwo_bigSmall() {
			return two_bigSmall;
		}
		public void setTwo_bigSmall(String two_bigSmall) {
			this.two_bigSmall = two_bigSmall;
		}
		public String getThree_bigSmall() {
			return three_bigSmall;
		}
		public void setThree_bigSmall(String three_bigSmall) {
			this.three_bigSmall = three_bigSmall;
		}
		public String getFour_bigSmall() {
			return four_bigSmall;
		}
		public void setFour_bigSmall(String four_bigSmall) {
			this.four_bigSmall = four_bigSmall;
		}
		public String getFive_bigSmall() {
			return five_bigSmall;
		}
		public void setFive_bigSmall(String five_bigSmall) {
			this.five_bigSmall = five_bigSmall;
		}
		public String getSix_bigSmall() {
			return six_bigSmall;
		}
		public void setSix_bigSmall(String six_bigSmall) {
			this.six_bigSmall = six_bigSmall;
		}
		public String getSeven_bigSmall() {
			return seven_bigSmall;
		}
		public void setSeven_bigSmall(String seven_bigSmall) {
			this.seven_bigSmall = seven_bigSmall;
		}
		public String getEight_bigSmall() {
			return eight_bigSmall;
		}
		public void setEight_bigSmall(String eight_bigSmall) {
			this.eight_bigSmall = eight_bigSmall;
		}
		public String getNine_bigSmall() {
			return nine_bigSmall;
		}
		public void setNine_bigSmall(String nine_bigSmall) {
			this.nine_bigSmall = nine_bigSmall;
		}
		public String getTen_bigSmall() {
			return ten_bigSmall;
		}
		public void setTen_bigSmall(String ten_bigSmall) {
			this.ten_bigSmall = ten_bigSmall;
		}
		public String getOne() {
			return one;
		}
		public void setOne(String one) {
			this.one = one;
		}
		public String getTwo() {
			return two;
		}
		public void setTwo(String two) {
			this.two = two;
		}
		public String getThree() {
			return three;
		}
		public void setThree(String three) {
			this.three = three;
		}
		public String getFour() {
			return four;
		}
		public void setFour(String four) {
			this.four = four;
		}
		public String getFive() {
			return five;
		}
		public void setFive(String five) {
			this.five = five;
		}
		public String getSix() {
			return six;
		}
		public void setSix(String six) {
			this.six = six;
		}
		public String getSeven() {
			return seven;
		}
		public void setSeven(String seven) {
			this.seven = seven;
		}
		public String getEight() {
			return eight;
		}
		public void setEight(String eight) {
			this.eight = eight;
		}
		public String getNine() {
			return nine;
		}
		public void setNine(String nine) {
			this.nine = nine;
		}
		public String getTen() {
			return ten;
		}
		public void setTen(String ten) {
			this.ten = ten;
		}
		public String getGone() {
			return gone;
		}
		public void setGone(String gone) {
			this.gone = gone;
		}
		public String getGtwo() {
			return gtwo;
		}
		public void setGtwo(String gtwo) {
			this.gtwo = gtwo;
		}
		public String getGthree() {
			return gthree;
		}
		public void setGthree(String gthree) {
			this.gthree = gthree;
		}
		public String getGfour() {
			return gfour;
		}
		public void setGfour(String gfour) {
			this.gfour = gfour;
		}
		public String getGfive() {
			return gfive;
		}
		public void setGfive(String gfive) {
			this.gfive = gfive;
		}
		public String getGsix() {
			return gsix;
		}
		public void setGsix(String gsix) {
			this.gsix = gsix;
		}
		public String getGseven() {
			return gseven;
		}
		public void setGseven(String gseven) {
			this.gseven = gseven;
		}
		public String getGeight() {
			return geight;
		}
		public void setGeight(String geight) {
			this.geight = geight;
		}
		public String getGnine() {
			return gnine;
		}
		public void setGnine(String gnine) {
			this.gnine = gnine;
		}
		public String getGten() {
			return gten;
		}
		public void setGten(String gten) {
			this.gten = gten;
		}
		public String getZone() {
			return zone;
		}
		public void setZone(String zone) {
			this.zone = zone;
		}
		public String getZtwo() {
			return ztwo;
		}
		public void setZtwo(String ztwo) {
			this.ztwo = ztwo;
		}
		public String getZthree() {
			return zthree;
		}
		public void setZthree(String zthree) {
			this.zthree = zthree;
		}
		public String getZfour() {
			return zfour;
		}
		public void setZfour(String zfour) {
			this.zfour = zfour;
		}
		public String getZfive() {
			return zfive;
		}
		public void setZfive(String zfive) {
			this.zfive = zfive;
		}
		public String getZsix() {
			return zsix;
		}
		public void setZsix(String zsix) {
			this.zsix = zsix;
		}
		public String getZseven() {
			return zseven;
		}
		public void setZseven(String zseven) {
			this.zseven = zseven;
		}
		public String getZeight() {
			return zeight;
		}
		public void setZeight(String zeight) {
			this.zeight = zeight;
		}
		public String getZnine() {
			return znine;
		}
		public void setZnine(String znine) {
			this.znine = znine;
		}
		public String getZten() {
			return zten;
		}
		public void setZten(String zten) {
			this.zten = zten;
		}
		public String getOne_jiOu() {
			return one_jiOu;
		}
		public void setOne_jiOu(String one_jiOu) {
			this.one_jiOu = one_jiOu;
		}
		public String getTwo_jiOu() {
			return two_jiOu;
		}
		public void setTwo_jiOu(String two_jiOu) {
			this.two_jiOu = two_jiOu;
		}
		public String getThree_jiOu() {
			return three_jiOu;
		}
		public void setThree_jiOu(String three_jiOu) {
			this.three_jiOu = three_jiOu;
		}
		public String getFour_jiOu() {
			return four_jiOu;
		}
		public void setFour_jiOu(String four_jiOu) {
			this.four_jiOu = four_jiOu;
		}
		public String getFive_jiOu() {
			return five_jiOu;
		}
		public void setFive_jiOu(String five_jiOu) {
			this.five_jiOu = five_jiOu;
		}
		public String getSix_jiOu() {
			return six_jiOu;
		}
		public void setSix_jiOu(String six_jiOu) {
			this.six_jiOu = six_jiOu;
		}
		public String getSeven_jiOu() {
			return seven_jiOu;
		}
		public void setSeven_jiOu(String seven_jiOu) {
			this.seven_jiOu = seven_jiOu;
		}
		public String getEight_jiOu() {
			return eight_jiOu;
		}
		public void setEight_jiOu(String eight_jiOu) {
			this.eight_jiOu = eight_jiOu;
		}
		public String getNine_jiOu() {
			return nine_jiOu;
		}
		public void setNine_jiOu(String nine_jiOu) {
			this.nine_jiOu = nine_jiOu;
		}
		public String getTen_jiOu() {
			return ten_jiOu;
		}
		public void setTen_jiOu(String ten_jiOu) {
			this.ten_jiOu = ten_jiOu;
		}
		
		

}
