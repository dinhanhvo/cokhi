package com.smartevn.cokhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartevn.cokhi.model.ApiResp;
import com.smartevn.cokhi.model.StyleSheetModel;
import com.smartevn.cokhi.repository.StyleSheetRepository;

@Controller
@RequestMapping("/api")
public class StyleSheetController {

    @Autowired
    private StyleSheetRepository styleSheetRepository;
    
    @GetMapping("/stylesheet/item/{id}")
    public ResponseEntity<ApiResp> getCssByItemId(@PathVariable("id") int id) {
        ApiResp apiResp = new ApiResp();

        List<StyleSheetModel> css = styleSheetRepository.findByItemId(id);
        apiResp.setData(css);
        
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PostMapping("/stylesheet")
    public ResponseEntity<ApiResp> addCss(@RequestBody StyleSheetModel css) {
        ApiResp apiResp = new ApiResp();

        StyleSheetModel cs = styleSheetRepository.save(css);
        apiResp.setData(cs);
        
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }

    @PutMapping("/stylesheet")
    public ResponseEntity<ApiResp> editCss(@RequestBody StyleSheetModel css) {
        ApiResp apiResp = new ApiResp();

        StyleSheetModel cs = styleSheetRepository.save(css);
        apiResp.setData(cs);
        
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }

}
