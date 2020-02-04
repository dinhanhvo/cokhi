package com.smartevn.cokhi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartevn.cokhi.model.ApiResp;
import com.smartevn.cokhi.model.ExportModel;
import com.smartevn.cokhi.repository.ExportRepository;

@Controller
@RequestMapping("/api")
public class ExportController {

    @Autowired 
    private ExportRepository exportRepository;
    
    @GetMapping("/exports")
    public ResponseEntity<ApiResp> getAllExports() {
        ApiResp apiResp = new ApiResp();
        List<ExportModel> ims = exportRepository.findAll();
        apiResp.setData(ims);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @GetMapping("/exports/product/{id}")
    public ResponseEntity<ApiResp> getExportsByProduct(@PathVariable(value="id") long prId) {
        ApiResp apiResp = new ApiResp();
        List<ExportModel> ims = exportRepository.findByProduct(prId);
        apiResp.setData(ims);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @GetMapping("/exports/product/date")
    public ResponseEntity<ApiResp> getExportsByProductAndDate(@RequestParam long product, @RequestParam Date date) {
        ApiResp apiResp = new ApiResp();
        List<ExportModel> ims = exportRepository.findByProductAndDate(product, date);
        apiResp.setData(ims);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @GetMapping("/exports/product/dates")
    public ResponseEntity<ApiResp> findByProductAndDates(@RequestParam("product") long product, @RequestParam("from") Date from, @RequestParam("to") Date to) {
        ApiResp apiResp = new ApiResp();
        List<ExportModel> ims = exportRepository.findByProductAndDates(from, to, product);
//        List<Object> ims = exportRepository.findExportGroupByName();
        apiResp.setData(ims);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PutMapping("/export")
    public ResponseEntity<ApiResp> editExport(@RequestBody ExportModel im) {
        ApiResp apiResp = new ApiResp();
        ExportModel i = exportRepository.save(im);
        
        List<ExportModel> ims = exportRepository.findAll();
        apiResp.setData(ims);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PostMapping("/export")
    public ResponseEntity<ApiResp> addExport(@RequestBody ExportModel im) {
        ApiResp apiResp = new ApiResp();
        ExportModel i = exportRepository.save(im);
        
        List<ExportModel> ims = exportRepository.findAll();
        apiResp.setData(ims);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/export/{id}")
    public ResponseEntity<ApiResp> deleteExport(@PathVariable("id") int id) {
        ApiResp apiResp = new ApiResp();
        exportRepository.deleteById(id);
        
        List<ExportModel> ims = exportRepository.findAll();
        apiResp.setData(ims);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
}
