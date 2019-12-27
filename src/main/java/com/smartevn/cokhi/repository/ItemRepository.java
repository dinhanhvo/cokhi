package com.smartevn.cokhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartevn.cokhi.model.ItemModel;

/**
 * 
 * @author vadinh
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Long> {

}
