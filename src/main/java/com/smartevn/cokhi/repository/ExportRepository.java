package com.smartevn.cokhi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartevn.cokhi.model.ExportModel;

@Repository
public interface ExportRepository extends JpaRepository<ExportModel, Integer>{

    public List<ExportModel> findByProduct(long num);
    public List<ExportModel> findByExportedAt(Date date);
    public List<ExportModel> findByCatcon(long num);
    public List<ExportModel> findByTn(long num);
    public List<ExportModel> findBySk1(long num);
    public List<ExportModel> findBySk2(long num);
    public List<ExportModel> findBySk3(long num);
    public List<ExportModel> findByNu(long num);
    public List<ExportModel> findByDan(long num);
    public List<ExportModel> findByNo(long num);
    public List<ExportModel> findByName(String name);
    
    @Query(value="SELECT ex.name, SUM(amount) AS total FROM export ex \r\n" + 
            "group by name" 
            , nativeQuery = true
            )
    public List<Object> findExportGroupByName();
    
//    @Query(value="select im.name, sum(amount) as total from export im \r\n" + 
//            "where im.exported_at between '?1' and '?2' \r\n" + 
//            "group by name"
//            )
//    public List<ExportModel> findByNameAndDates(String name, Date dt1, Date dt2);
    
    
    @Query(value="SELECT * FROM export ex \r\n" + 
            "where ex.product = ?1 \r\n" +
            "and ex.exported_at = ?2 \r\n"  
//            "group by product \r\n"
            , nativeQuery = true
            )
    public List<ExportModel> findByProductAndDate(long prId, Date dt);
    
    @Query(value="SELECT * FROM export ex \r\n" + 
            "WHERE (DATEDIFF(ex.exported_at, ?1) >= 0 AND DATEDIFF(?2, ex.exported_at) >= 0) \r\n" + 
            "AND ex.product = ?3 \r\n"
//            "group by product"
            , nativeQuery = true
            )
//    @Query(value="select * from export ex \r\n" + 
//            "where ex.exported_at between '2020/01/01' and '2020/01/28'\r\n" + 
//            "and product = 7",
//            nativeQuery = true)
    public List<ExportModel> findByProductAndDates(Date dt1, Date dt2, long prId);
    
    public List<ExportModel> findByAmount(long num);
}
