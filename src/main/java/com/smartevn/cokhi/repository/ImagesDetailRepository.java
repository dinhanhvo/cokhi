package com.smartevn.cokhi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartevn.cokhi.model.ImagesDetail;

@Repository
public interface ImagesDetailRepository extends JpaRepository<ImagesDetail, Long> {

    @Query(value = "SELECT * FROM images_detail i WHERE i.product_id = ?1", nativeQuery = true)
    List<ImagesDetail> findByProductIds(long id);
    
    List<ImagesDetail> findByProductId(Long id);
}
