package com.smartevn.cokhi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartevn.cokhi.model.ExportModel;
import com.smartevn.cokhi.repository.ExportRepository;

@Service
public class ExportService {

    @Autowired
    public ExportRepository exportRepository;
    
//    public List<ExportModel> getAllExports() {
//        return exportRepository.findAll(); 
//    }
    
    public List<ExportModel> findByCatcon(long num) {
        return exportRepository.findByCatcon(num); 
    }
    
    public List<ExportModel> findByAmount(long num) {
        return exportRepository.findByAmount(num); 
    }
    
    public List<ExportModel> findByDan(long num) {
        return exportRepository.findByDan(num); 
    }
    
    public List<ExportModel> getAllExports(Date dt) {
        return exportRepository.findByExportedAt(dt); 
    }
    
    public List<ExportModel> getByName(String name) {
        return exportRepository.findByName(name);  
    }
    
    public List<ExportModel> getByProduct(long prId) {
        return exportRepository.findByProduct(prId);  
    }

//    public List<ExportModel> getByNameAndDate(String name, Date dt) {
//        return exportRepository.findByNameAndDate(name, dt);  
//    }

//    public List<ExportModel> getByNameAndDates(String name, Date dt1, Date dt2) {
//        return exportRepository.findByNameAndDates(name, dt1, dt2);  
//    }

    public List<ExportModel> getByProductAndDate(long prid, Date dt) {
        return exportRepository.findByProductAndDate(prid, dt);  
    }

    public List<ExportModel> getByProductAndDates(long prid, Date dt1, Date dt2) {
        return exportRepository.findByProductAndDates(dt1, dt2, prid);  
    }

}
