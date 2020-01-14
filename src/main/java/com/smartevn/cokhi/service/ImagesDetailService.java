package com.smartevn.cokhi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartevn.cokhi.model.ImagesDetail;
import com.smartevn.cokhi.model.Product;
import com.smartevn.cokhi.repository.ImagesDetailRepository;

@Service
public class ImagesDetailService {

    @Autowired
    ImagesDetailRepository imageDetailrepository;
    
    public ArrayList<ImagesDetail> getImagesByProductid(long prId) {
        System.out.println("ImagesDetailService.getImagesByProductid()------prId--" + prId);
        return (ArrayList<ImagesDetail>) this.imageDetailrepository.findByProductId(prId);
    }
    
    public ImagesDetail addImage(ImagesDetail img) {
        return this.imageDetailrepository.save(img);
    }
    
    public ImagesDetail editImage(ImagesDetail img) {
        System.out.println("editImage===" + img.getId());
        ImagesDetail imgR = imageDetailrepository.save(img);
        return imgR;
    }
    
    public void deleteImage(long id) {
        imageDetailrepository.deleteById(id);
    }

}
