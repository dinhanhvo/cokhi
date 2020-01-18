package com.smartevn.cokhi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.smartevn.cokhi.model.ApiResp;
import com.smartevn.cokhi.model.ImagesDetail;
import com.smartevn.cokhi.model.Product;
import com.smartevn.cokhi.payload.PagedResponse;
import com.smartevn.cokhi.security.CurrentUser;
import com.smartevn.cokhi.security.UserPrincipal;
import com.smartevn.cokhi.service.ImagesDetailService;
import com.smartevn.cokhi.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ImagesDetailService imagesDetailService;
    
//    @GetMapping("/product")
//    public PagedResponse<Product> getAllProducts(@CurrentUser UserPrincipal currentUser,
//            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
//            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
//        
//        logger.info("=======getAllProducts======page=="+page+"====size=="+size+"===========");
//        return productService.getAllProducts(currentUser, page, size);
//    }
    
    @GetMapping("/products")
    public ResponseEntity<ApiResp> getProducts(@CurrentUser UserPrincipal currentUser) {

        ApiResp apiResp = new ApiResp();
        List<Product> prs = productService.getProducts();
        apiResp.setData(prs);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @GetMapping("/products/category/{id}")
    public ResponseEntity<ApiResp> getProductsByCategory(@PathVariable("id") int cateId) {
        ApiResp apiResp = new ApiResp();
        List<Product> prs = productService.getProductByCategory(cateId);
        apiResp.setData(prs);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }

    @GetMapping("/products/type/{id}")
    public ResponseEntity<ApiResp> getProductsByType(@PathVariable("id") int type) {
        ApiResp apiResp = new ApiResp();
        List<Product> prs = productService.getProductByType(type);
        apiResp.setData(prs);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ApiResp> getProduct(@PathVariable("id") long prId) {
        System.out.println("ProductController.getProduct() id =====" + prId);
        ApiResp apiResp = new ApiResp();
        Optional<Product> pr = productService.getProduct(prId);
        apiResp.setData(pr);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @SuppressWarnings("unchecked")
    @PostMapping("/product")
    public ResponseEntity<ApiResp> addProduct(@Valid @RequestBody Product prod) {
        ApiResp apiResp = new ApiResp();
        System.out.println("ProductController.addProduct()========" + prod.getImagepath());
        
        Gson gson = new Gson();
        ArrayList<String> imgs = gson.fromJson(prod.getImagepath(), ArrayList.class);
        prod.setImagepath(imgs.get(0));
        
        Product pr = productService.addProduct(prod);
        apiResp.setData(pr);
        
        for (String img: imgs) {
            ImagesDetail imgModel = new ImagesDetail();
            imgModel.setName(prod.getName());
            imgModel.setImgpath(img);
            imgModel.setType(1);
            imgModel.setProductId(prod.getId());
            System.out.println(imgModel.getProductId() + "ProductController.addProduct()======" + imgModel.getImgpath());
            this.imagesDetailService.addImage(imgModel);
        }
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @PutMapping("/product")
    public ResponseEntity<ApiResp> editProduct(@Valid @RequestBody Product prod) {
        ApiResp apiResp = new ApiResp();
        System.out.println("ProductController.editProduct()====getId====" + prod.getId());
        
        Product pr = productService.editProduct(prod);
//        apiResp.setData(pr);
        List<Product> prs = productService.getProducts();
        apiResp.setData(prs);
        
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
    
    @DeleteMapping("/product/{id}")
    public ResponseEntity<ApiResp> deleteCategory(@PathVariable("id") long id) {
        ApiResp apiResp = new ApiResp();
        productService.deleteProduct(id);
        apiResp.setData("Deleted category "+id);
        return new ResponseEntity<ApiResp>(apiResp, HttpStatus.OK);
    }
}
