package com.smartevn.cokhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartevn.cokhi.model.ImportModel;

@Repository
public interface ImportRepository extends JpaRepository<ImportModel, Integer>{

}
