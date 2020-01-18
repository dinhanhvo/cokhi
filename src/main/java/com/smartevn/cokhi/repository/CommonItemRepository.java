package com.smartevn.cokhi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartevn.cokhi.model.CommonItemModel;

@Repository
public interface CommonItemRepository extends JpaRepository<CommonItemModel, Long>{

    List<CommonItemModel> findByType(int type);
}
