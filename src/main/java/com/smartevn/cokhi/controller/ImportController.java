package com.smartevn.cokhi.controller;

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

import com.smartevn.cokhi.model.ApiResp;
import com.smartevn.cokhi.model.CategoryModel;
import com.smartevn.cokhi.model.ImportModel;
import com.smartevn.cokhi.repository.ImportRepository;

@Controller
@RequestMapping("/api")
public class ImportController {

    @Autowired 
    private ImportRepository importRepository;
    
    @GetMapping("/imports")
    public ResponseEntity<ApiResp> getAllImports() {
        ApiResp apiResp = new ApiResp();
        List<ImportModel> ims = importRepository.findAll();
        apiResp.setData(ims);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }

    @PutMapping("/import")
    public ResponseEntity<ApiResp> editImport(@RequestBody ImportModel im) {
        ApiResp apiResp = new ApiResp();
        ImportModel i = importRepository.save(im);
        
        List<ImportModel> ims = importRepository.findAll();
        apiResp.setData(ims);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PostMapping("/import")
    public ResponseEntity<ApiResp> addImport(@RequestBody ImportModel im) {
        ApiResp apiResp = new ApiResp();
        ImportModel i = importRepository.save(im);
        
        List<ImportModel> ims = importRepository.findAll();
        apiResp.setData(ims);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/import/{id}")
    public ResponseEntity<ApiResp> deleteImport(@PathVariable("id") int id) {
        ApiResp apiResp = new ApiResp();
        importRepository.deleteById(id);
        
        List<ImportModel> ims = importRepository.findAll();
        apiResp.setData(ims);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
}
