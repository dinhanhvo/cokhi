package com.smartevn.cokhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartevn.cokhi.model.ImagesDetail;

@Repository
public interface Images_Detail extends JpaRepository<ImagesDetail, Long> {

}
