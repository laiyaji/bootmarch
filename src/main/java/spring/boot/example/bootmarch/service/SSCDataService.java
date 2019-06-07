package spring.boot.example.bootmarch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.boot.example.bootmarch.dao.SSCDataMapper;
import spring.boot.example.bootmarch.domain.PK10Data;
import spring.boot.example.bootmarch.domain.SSCData;

@Service("sscDataService")
public class SSCDataService {
	@Autowired
	private SSCDataMapper sscDataMapper;

	public List<SSCData> findSSCList(SSCData ssc) {
		return sscDataMapper.findSSCList(ssc);
	}

	@Transactional
	public int addSSCData(SSCData ssc) {
		return sscDataMapper.addSSCData(ssc);
	}

	@Transactional
	public void addBatchSSCHistory(List<SSCData> list) {
		sscDataMapper.addBatchSSCHistory(list);
	}
	@Transactional
	public void addPK10Batch(List<PK10Data> list) {
		sscDataMapper.addPK10Batch(list);
	}

	public List<SSCData> findSSCHistoryList(SSCData ssc) {
		List<SSCData> list=sscDataMapper.findSSCHistoryList(ssc);
		List<SSCData> resList=new ArrayList<SSCData>();
		if(null!=list&&list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				SSCData sscData=list.get(i);
				String [] no=sscData.getNumber().split(",");
				sscData.setWan(no[0]);
				sscData.setQian(no[1]);
				sscData.setBai(no[2]);
				sscData.setShi(no[3]);
				sscData.setGe(no[4]);
				if(Integer.parseInt(sscData.getGe())>4) {
					sscData.setGe_bigSmall("大");
				}else {
					sscData.setGe_bigSmall("小");
				}
				
				if(Integer.parseInt(sscData.getShi())>4) {
					sscData.setShi_bigSmall("大");
				}else {
					sscData.setShi_bigSmall("小");
				}
				
				if(Integer.parseInt(sscData.getBai())>4) {
					sscData.setBai_bigSmall("大");
				}else {
					sscData.setBai_bigSmall("小");
				}
				
				if(Integer.parseInt(sscData.getQian())>4) {
					sscData.setQian_bigSmall("大");
				}else {
					sscData.setQian_bigSmall("小");
				}
				
				if(Integer.parseInt(sscData.getWan())>4) {
					sscData.setWan_bigSmall("大");
				}else {
					sscData.setWan_bigSmall("小");
				}
				resList.add(sscData);
			}
			int currentValW=0,beforeW=0,currentValQ=0,beforeQ=0,currentValB=0,beforeB=0,currentValS=0,beforeS=0,currentValG=0,beforeG=0;
			int zWan=0,gWan=0,zQian=0,gQian=0,zBai=0,gBai=0,zShi=0,gShi=0,zGe=0,gGe=0;
			int tgWan=0,tgQian=0,tgBai=0,tgShi=0,tgGe=0;
			for (int i = 1; i < resList.size(); i++) {
				beforeG=Integer.parseInt(resList.get((i-1)).getGe());
				currentValG=Integer.parseInt(resList.get(i).getGe());
				beforeS=Integer.parseInt(resList.get((i-1)).getShi());
				currentValS=Integer.parseInt(resList.get(i).getShi());
				beforeB=Integer.parseInt(resList.get((i-1)).getBai());
				currentValB=Integer.parseInt(resList.get(i).getBai());
				beforeQ=Integer.parseInt(resList.get((i-1)).getQian());
				currentValQ=Integer.parseInt(resList.get(i).getQian());
				beforeW=Integer.parseInt(resList.get((i-1)).getWan());
				currentValW=Integer.parseInt(resList.get(i).getWan());
				
				// 个位统计
				if((currentValG<5&&beforeG<5) || (currentValG>4&&beforeG>4)) {
					if(gGe>tgGe) {
						tgGe=gGe;
					}
					zGe++;
					gGe=0;
					
				}else {
					gGe++;
				}
				
				// 十位统计
				if((currentValS<5&&beforeS<5) || (currentValS>4&&beforeS>4)) {
					if(gShi>tgShi) {
						tgShi=gShi;
					}
					zShi++;
					gShi=0;
				}else {
					gShi++;
				}
				
				// 百位统计
				if((currentValB<5&&beforeB<5) || (currentValB>4&&beforeB>4)) {
					if(gBai>tgBai) {
						tgBai=gBai;
					}
					zBai++;
					gBai=0;
				}else {
					gBai++;
				}
				
				// 千位统计
				if((currentValQ<5&&beforeQ<5) || (currentValQ>4&&beforeQ>4)) {
					if(gQian>tgQian) {
						tgQian=gQian;
					}
					zQian++;
					gQian=0;
				}else {
					gQian++;
				}
				
				// 万位统计
				if((currentValW<5&&beforeW<5) || (currentValW>4&&beforeW>4)) {
					if(gWan>tgWan) {
						tgWan=gWan;
					}
					zWan++;
					gWan=0;
				}else {
					gWan++;
				}
			}

			SSCData sscChange=resList.get((resList.size()-1));
			
			sscChange.setGuawan(tgWan>gWan?String.valueOf(tgWan):String.valueOf(gWan));
			sscChange.setGzwan(String.valueOf(zWan));
			
			sscChange.setGuaqian(tgQian>gQian?String.valueOf(tgQian):String.valueOf(gQian));
			sscChange.setGzqian(String.valueOf(zQian));
			
			sscChange.setGuabai(tgBai>gBai?String.valueOf(tgBai):String.valueOf(gBai));
			sscChange.setGzbai(String.valueOf(zBai));
			
			sscChange.setGuashi(tgShi>gShi?String.valueOf(tgShi):String.valueOf(gShi));
			sscChange.setGzshi(String.valueOf(zShi));
			
			sscChange.setGuage(tgGe>gGe?String.valueOf(tgGe):String.valueOf(gGe));
			sscChange.setGzge(String.valueOf(zGe));
			
			resList.set((resList.size()-1), sscChange);
		}
		
		return resList;
	}
	
	
	public List<PK10Data> findPK10History(PK10Data pk10) {
		List<PK10Data> list=sscDataMapper.findPK10History(pk10);
		List<PK10Data> resList=new ArrayList<PK10Data>();
		if(null!=list&&list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				PK10Data pk10Data=list.get(i);
				String [] no=pk10Data.getPk10_number().split(",");
				pk10Data.setOne(String.valueOf(Integer.parseInt(no[0])));
				pk10Data.setTwo(String.valueOf(Integer.parseInt(no[1])));
				pk10Data.setThree(String.valueOf(Integer.parseInt(no[2])));
				pk10Data.setFour(String.valueOf(Integer.parseInt(no[3])));
				pk10Data.setFive(String.valueOf(Integer.parseInt(no[4])));
				pk10Data.setSix(String.valueOf(Integer.parseInt(no[5])));
				pk10Data.setSeven(String.valueOf(Integer.parseInt(no[6])));
				pk10Data.setEight(String.valueOf(Integer.parseInt(no[7])));
				pk10Data.setNine(String.valueOf(Integer.parseInt(no[8])));
				pk10Data.setTen(String.valueOf(Integer.parseInt(no[9])));
			    List<String> jiList=new ArrayList<String>();
			    List<String> ouList=new ArrayList<String>();
			    jiList.add("1");
			    jiList.add("3");
			    jiList.add("5");
			    jiList.add("7");
			    jiList.add("9");
			    ouList.add("2");
			    ouList.add("4");
			    ouList.add("6");
			    ouList.add("8");
			    ouList.add("10");
				if(Integer.parseInt(pk10Data.getOne())>5) {
					pk10Data.setOne_bigSmall("大");
				}else {
					pk10Data.setOne_bigSmall("小");
				}
				if(jiList.contains(pk10Data.getOne())) {
					pk10Data.setOne_jiOu("奇");
				}else {
					pk10Data.setOne_jiOu("偶");
				}
				
				if(Integer.parseInt(pk10Data.getTwo())>5) {
					pk10Data.setTwo_bigSmall("大");
				}else {
					pk10Data.setTwo_bigSmall("小");
				}
				if(jiList.contains(pk10Data.getTwo())) {
					pk10Data.setTwo_jiOu("奇");
				}else {
					pk10Data.setTwo_jiOu("偶");
				}
				
				if(Integer.parseInt(pk10Data.getThree())>5) {
					pk10Data.setThree_bigSmall("大");
				}else {
					pk10Data.setThree_bigSmall("小");
				}
				if(jiList.contains(pk10Data.getThree())) {
					pk10Data.setThree_jiOu("奇");
				}else {
					pk10Data.setThree_jiOu("偶");
				}
				
				if(Integer.parseInt(pk10Data.getFour())>5) {
					pk10Data.setFour_bigSmall("大");
				}else {
					pk10Data.setFour_bigSmall("小");
				}
				if(jiList.contains(pk10Data.getFour())) {
					pk10Data.setFour_jiOu("奇");
				}else {
					pk10Data.setFour_jiOu("偶");
				}
				if(Integer.parseInt(pk10Data.getFive())>5) {
					pk10Data.setFive_bigSmall("大");
				}else {
					pk10Data.setFive_bigSmall("小");
				}
				if(jiList.contains(pk10Data.getFive())) {
					pk10Data.setFive_jiOu("奇");
				}else {
					pk10Data.setFive_jiOu("偶");
				}
				
				if(Integer.parseInt(pk10Data.getSix())>5) {
					pk10Data.setSix_bigSmall("大");
				}else {
					pk10Data.setSix_bigSmall("小");
				}
				if(jiList.contains(pk10Data.getSix())) {
					pk10Data.setSix_jiOu("奇");
				}else {
					pk10Data.setSix_jiOu("偶");
				}
				if(Integer.parseInt(pk10Data.getSeven())>5) {
					pk10Data.setSeven_bigSmall("大");
				}else {
					pk10Data.setSeven_bigSmall("小");
				}
				
				if(jiList.contains(pk10Data.getSeven())) {
					pk10Data.setSeven_jiOu("奇");
				}else {
					pk10Data.setSeven_jiOu("偶");
				}
				
				if(Integer.parseInt(pk10Data.getEight())>5) {
					pk10Data.setEight_bigSmall("大");
				}else {
					pk10Data.setEight_bigSmall("小");
				}
				
				if(jiList.contains(pk10Data.getEight())) {
					pk10Data.setEight_jiOu("奇");
				}else {
					pk10Data.setEight_jiOu("偶");
				}
				
				if(Integer.parseInt(pk10Data.getNine())>5) {
					pk10Data.setNine_bigSmall("大");
				}else {
					pk10Data.setNine_bigSmall("小");
				}
				if(jiList.contains(pk10Data.getNine())) {
					pk10Data.setNine_jiOu("奇");
				}else {
					pk10Data.setNine_jiOu("偶");
				}
				
				if(Integer.parseInt(pk10Data.getTen())>5) {
					pk10Data.setTen_bigSmall("大");
				}else {
					pk10Data.setTen_bigSmall("小");
				}
				if(jiList.contains(pk10Data.getTen())) {
					pk10Data.setTen_jiOu("奇");
				}else {
					pk10Data.setTen_jiOu("偶");
				}
				resList.add(pk10Data);
			}
			int currentVal1=0,before1=0,currentVal2=0,before2=0,currentVal3=0,before3=0,currentVal4=0,before4=0,currentVal5=0,before5=0,currentVal6=0,before6=0,currentVal7=0,before7=0,currentVal8=0,before8=0,currentVal9=0,before9=0,currentVal10=0,before10=0;
			int z1=0,g1=0,z2=0,g2=0,z3=0,g3=0,z4=0,g4=0,z5=0,g5=0,z6=0,g6=0,z7=0,g7=0,z8=0,g8=0,z9=0,g9=0,z10=0,g10=0;
			int tg1=0,tg2=0,tg3=0,tg4=0,tg5=0,tg6=0,tg7=0,tg8=0,tg9=0,tg10=0;
			for (int i = 1; i < resList.size(); i++) {
				before1=Integer.parseInt(resList.get((i-1)).getOne());
				currentVal1=Integer.parseInt(resList.get(i).getOne());
				before2=Integer.parseInt(resList.get((i-1)).getTwo());
				currentVal2=Integer.parseInt(resList.get(i).getTwo());
				before3=Integer.parseInt(resList.get((i-1)).getThree());
				currentVal3=Integer.parseInt(resList.get(i).getThree());
				before4=Integer.parseInt(resList.get((i-1)).getFour());
				currentVal4=Integer.parseInt(resList.get(i).getFour());
				before5=Integer.parseInt(resList.get((i-1)).getFive());
				currentVal5=Integer.parseInt(resList.get(i).getFive());
				
				before6=Integer.parseInt(resList.get((i-1)).getSix());
				currentVal6=Integer.parseInt(resList.get(i).getSix());
				before7=Integer.parseInt(resList.get((i-1)).getSeven());
				currentVal7=Integer.parseInt(resList.get(i).getSeven());
				before8=Integer.parseInt(resList.get((i-1)).getEight());
				currentVal8=Integer.parseInt(resList.get(i).getEight());
				before9=Integer.parseInt(resList.get((i-1)).getNine());
				currentVal9=Integer.parseInt(resList.get(i).getNine());
				before10=Integer.parseInt(resList.get((i-1)).getTen());
				currentVal10=Integer.parseInt(resList.get(i).getTen());
				
				// 个位统计
				if((currentVal1<6&&before1<6) || (currentVal1>5&&before1>5)) {
					if(g1>tg1) {
						tg1=g1;
					}
					z1++;
					g1=0;
					
				}else {
					g1++;
				}
				
				// 十位统计
				if((currentVal2<6&&before2<6) || (currentVal2>5&&before2>5)) {
					if(g2>tg2) {
						tg2=g2;
					}
					z2++;
					g2=0;
				}else {
					g2++;
				}
				
				// 百位统计
				if((currentVal3<6&&before3<6) || (currentVal3>5&&before3>5)) {
					if(g3>tg3) {
						tg3=g3;
					}
					z3++;
					g3=0;
				}else {
					g3++;
				}
				
				// 千位统计
				if((currentVal4<6&&before4<6) || (currentVal4>5&&before4>5)) {
					if(g4>tg4) {
						tg4=g4;
					}
					z4++;
					g4=0;
				}else {
					g4++;
				}
				
				// 万位统计
				if((currentVal5<6&&before5<6) || (currentVal5>5&&before5>5)) {
					if(g5>tg5) {
						tg5=g5;
					}
					z5++;
					g5=0;
				}else {
					g5++;
				}
				
				
				
				
				// 个位统计
				if((currentVal6<6&&before6<6) || (currentVal6>5&&before6>5)) {
					if(g6>tg6) {
						tg6=g6;
					}
					z6++;
					g6=0;
					
				}else {
					g6++;
				}
				
				// 十位统计
				if((currentVal7<6&&before7<6) || (currentVal7>5&&before7>5)) {
					if(g7>tg7) {
						tg7=g7;
					}
					z7++;
					g7=0;
				}else {
					g7++;
				}
				
				// 百位统计
				if((currentVal8<6&&before8<6) || (currentVal8>5&&before8>5)) {
					if(g8>tg8) {
						tg8=g8;
					}
					z8++;
					g8=0;
				}else {
					g8++;
				}
				
				// 千位统计
				if((currentVal9<6&&before9<6) || (currentVal9>5&&before9>5)) {
					if(g9>tg9) {
						tg9=g9;
					}
					z9++;
					g9=0;
				}else {
					g9++;
				}
				
				// 万位统计
				if((currentVal10<6&&before10<6) || (currentVal10>5&&before10>5)) {
					if(g10>tg10) {
						tg10=g10;
					}
					z10++;
					g10=0;
				}else {
					g10++;
				}
			}
			
			PK10Data sscChange=resList.get((resList.size()-1));
			
			sscChange.setGone(String.valueOf(tg1));
			sscChange.setZone(String.valueOf(z1));
			sscChange.setGtwo(String.valueOf(tg2));
			sscChange.setZtwo(String.valueOf(z2));
			sscChange.setGthree(String.valueOf(tg3));
			sscChange.setZthree(String.valueOf(z3));
			sscChange.setGfour(String.valueOf(tg4));
			sscChange.setZfour(String.valueOf(z4));
			sscChange.setGfive(String.valueOf(tg5));
			sscChange.setZfive(String.valueOf(z5));
			sscChange.setGsix(String.valueOf(tg6));
			sscChange.setZsix(String.valueOf(z6));
			sscChange.setGseven(String.valueOf(tg7));
			sscChange.setZseven(String.valueOf(z7));
			sscChange.setGeight(String.valueOf(tg8));
			sscChange.setZeight(String.valueOf(z8));
			sscChange.setGnine(String.valueOf(tg9));
			sscChange.setZnine(String.valueOf(z9));
			sscChange.setGten(String.valueOf(tg10));
			sscChange.setZten(String.valueOf(z10));
			
			
			resList.set((resList.size()-1), sscChange);
		}
		
		return resList;
	}
	
}
