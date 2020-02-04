package com.smartevn.cokhi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartevn.cokhi.model.ExportModel;
import com.smartevn.cokhi.model.ImportModel;

@Repository
public interface ImportRepository extends JpaRepository<ImportModel, Integer>{

    public List<ImportModel> findByAmount(long amount);
    public List<ImportModel> findByName(String name);
    public List<ImportModel> findByImportedAt(Date date);
    public List<ImportModel> findByUser(int userId);
    public List<ImportModel> findByProduct(long prId);
    
    @Query(value="SELECT im.name, SUM(amount) AS total FROM import im \r\n" + 
            "where im.product = ?1 \r\n" +
            "where im.imported_at = ?2 \r\n"  
//            "group by product \r\n"
            , nativeQuery = true
            )
    public List<ImportModel> findByProductAndDate(long prId, Date dt);
    
//    @Query(value="SELECT im.name, SUM(amount) AS total FROM import im \r\n" + 
//            "where im.imported_at between ?1 and ?2 \r\n" + 
//            "where im.product = ?3 \r\n"
////            "group by product"
//            , nativeQuery = true
//            )
//    public List<ImportModel> findByProductAndDates(Date dt1, Date dt2, long prId);
    
    @Query(value="SELECT * FROM import ex \r\n" + 
            "WHERE (DATEDIFF(ex.imported_at, ?1) >= 0 AND DATEDIFF(?2, ex.imported_at) >= 0) \r\n" + 
            "AND ex.product = ?3 \r\n"
//            "group by product"
            , nativeQuery = true
            )
//    @Query(value="select * from export ex \r\n" + 
//            "where ex.exported_at between '2020/01/01' and '2020/01/28'\r\n" + 
//            "and product = 7",
//            nativeQuery = true)
    public List<ImportModel> findByProductAndDates(Date dt1, Date dt2, long prId);
}
