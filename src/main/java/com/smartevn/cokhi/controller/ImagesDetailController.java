package com.smartevn.cokhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartevn.cokhi.model.ApiResp;
import com.smartevn.cokhi.model.ImagesDetail;
import com.smartevn.cokhi.service.ImagesDetailService;

@Controller
@RequestMapping("/api")
public class ImagesDetailController {
    
    @Autowired
    ImagesDetailService imagesDetailService;
    
    @GetMapping("/product/imgs/{prId}")
    public ResponseEntity<ApiResp> getImagesByProductId(@PathVariable("prId") long prId) {
        ApiResp apiResp = new ApiResp();
        List<ImagesDetail> imgs = imagesDetailService.getImagesByProductid(prId);
        apiResp.setData(imgs);
        System.out.println("ImagesDetailController.getImagesByProductId()==imgs size: " + imgs.size());
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
}
