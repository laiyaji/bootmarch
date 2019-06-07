package spring.boot.example.bootmarch.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import spring.boot.example.bootmarch.domain.PK10Data;
import spring.boot.example.bootmarch.domain.SSCData;

@Repository("sscDataMapper")
public interface SSCDataMapper {

	List<SSCData> findSSCList(SSCData ssc);

	List<SSCData> findSSCHistoryList(SSCData ssc);
	
	List<PK10Data> findPK10History(PK10Data ssc);

	int addSSCData(SSCData ssc);

	void addBatchSSCHistory(List<SSCData> list);

	void addPK10Batch(List<PK10Data> list);

}
