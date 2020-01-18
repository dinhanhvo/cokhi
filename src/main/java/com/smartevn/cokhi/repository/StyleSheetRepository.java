package com.smartevn.cokhi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartevn.cokhi.model.StyleSheetModel;

@Repository
public interface StyleSheetRepository extends JpaRepository<StyleSheetModel, Long>{

    List<StyleSheetModel> findByItemId(long id);
}
