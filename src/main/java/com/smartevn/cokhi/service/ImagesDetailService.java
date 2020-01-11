package com.smartevn.cokhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartevn.cokhi.model.ImagesDetail;
import com.smartevn.cokhi.repository.Images_Detail;

@Service
public class ImagesDetailService {

    @Autowired
    Images_Detail images_detail;
    
    public void AddImage(ImagesDetail img) {
        this.images_detail.save(img);
    }
}
