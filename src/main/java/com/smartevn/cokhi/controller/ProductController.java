package com.smartevn.cokhi.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartevn.cokhi.model.ApiResp;
import com.smartevn.cokhi.model.Product;
import com.smartevn.cokhi.payload.PagedResponse;
import com.smartevn.cokhi.security.CurrentUser;
import com.smartevn.cokhi.security.UserPrincipal;
import com.smartevn.cokhi.service.ProductService;
import com.smartevn.cokhi.util.AppConstants;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;
    
    @GetMapping("/product")
    public PagedResponse<Product> getAllProducts(@CurrentUser UserPrincipal currentUser,
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        
        logger.info("=======getAllProducts======page=="+page+"====size=="+size+"===========");
        return productService.getAllProducts(currentUser, page, size);
    }
    
    @GetMapping("/products")
    public ResponseEntity<ApiResp> getProducts(@CurrentUser UserPrincipal currentUser) {

        ApiResp apiResp = new ApiResp();
        List<Product> prs = productService.getProducts();
        apiResp.setData(prs);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PostMapping("/product")
    public ResponseEntity<ApiResp> addProduct(@Valid @RequestBody Product prod) {
        ApiResp apiResp = new ApiResp();
        System.out.println("ProductController.addProduct()========" + prod.getImagepath());
        Product pr = productService.addProduct(prod);
        apiResp.setData(pr);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
}
