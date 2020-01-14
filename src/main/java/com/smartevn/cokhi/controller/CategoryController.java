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
import com.smartevn.cokhi.repository.CategoryRepository;

@Controller
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepositoy;
    
    @GetMapping("/categories")
    public ResponseEntity<ApiResp> getCategories() {
        ApiResp apiResp = new ApiResp();
        List<CategoryModel> categories = categoryRepositoy.findAll();
        apiResp.setData(categories);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PostMapping("/category")
    public ResponseEntity<ApiResp> addCategory(@RequestBody CategoryModel cate) {
        ApiResp apiResp = new ApiResp();
        CategoryModel cateR = categoryRepositoy.save(cate);
        
        List<CategoryModel> categories = categoryRepositoy.findAll();
        apiResp.setData(categories);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PutMapping("/category")
    public ResponseEntity<ApiResp> editCategory(@RequestBody CategoryModel cate) {
        ApiResp apiResp = new ApiResp();
        CategoryModel cateR = categoryRepositoy.save(cate);
        List<CategoryModel> categories = categoryRepositoy.findAll();
        apiResp.setData(categories);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/category/{id}")
    public ResponseEntity<ApiResp> deleteCategory(@PathVariable("id") long id) {
        ApiResp apiResp = new ApiResp();
        categoryRepositoy.deleteById(id);
        List<CategoryModel> categories = categoryRepositoy.findAll();
        apiResp.setData(categories);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
}
