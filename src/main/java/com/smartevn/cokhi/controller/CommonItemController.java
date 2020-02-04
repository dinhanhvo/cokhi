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
import com.smartevn.cokhi.model.CommonItemModel;
import com.smartevn.cokhi.repository.CommonItemRepository;

@Controller
@RequestMapping("/api")
public class CommonItemController {

    @Autowired
    private CommonItemRepository commonItemReporitory;

    @GetMapping("/commonitems")
    public ResponseEntity<ApiResp> getItems() {
        ApiResp apiResp = new ApiResp();
        List<CommonItemModel> cim = commonItemReporitory.findAll();
        apiResp.setData(cim);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }

    @GetMapping("/commonitem/type/{id}")
    public ResponseEntity<ApiResp> getItemByType(@PathVariable("id") int id) {
        ApiResp apiResp = new ApiResp();
        List<CommonItemModel> cim = commonItemReporitory.findByType(id);
        apiResp.setData(cim);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PostMapping("/commonitem")
    public ResponseEntity<ApiResp> addItem(@RequestBody CommonItemModel item) {
        ApiResp apiResp = new ApiResp();
        CommonItemModel it = commonItemReporitory.save(item);
        if (null != it) {
            List<CommonItemModel> cim = commonItemReporitory.findAll();
            apiResp.setData(cim);
            return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
        } else {
            return new ResponseEntity<ApiResp>(apiResp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/commonitem")
    public ResponseEntity<ApiResp> editItem(@RequestBody CommonItemModel item) {
        ApiResp apiResp = new ApiResp();
        CommonItemModel it = commonItemReporitory.save(item);
        if (null != it) {
            List<CommonItemModel> cim = commonItemReporitory.findAll();
            apiResp.setData(cim);
            return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
        } else {
            return new ResponseEntity<ApiResp>(apiResp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/commonitem/{id}")
    public ResponseEntity<ApiResp> deleteCategory(@PathVariable("id") long id) {
        ApiResp apiResp = new ApiResp();
        commonItemReporitory.deleteById(id);
        List<CommonItemModel> categories = commonItemReporitory.findAll();
        apiResp.setData(categories);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
}
