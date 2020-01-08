package com.smartevn.cokhi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.smartevn.cokhi.exception.BadRequestException;
import com.smartevn.cokhi.model.Product;
import com.smartevn.cokhi.payload.PagedResponse;
import com.smartevn.cokhi.repository.ProductRepository;
import com.smartevn.cokhi.security.UserPrincipal;
import com.smartevn.cokhi.util.AppConstants;

/**
 * 
 * @author vadinh
 *
 */

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    
    @Autowired
    private ProductRepository productRepository;
    
    public PagedResponse<Product> getAllProducts(UserPrincipal currentUser, int page, int size) {
        validatePageNumberAndSize(page, size);

        // Retrieve Products
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
        Page<Product> products = productRepository.findAll(pageable);

        if(products.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), products.getNumber(),
                    products.getSize(), products.getTotalElements(), products.getTotalPages(), products.isLast());
        }

        // Map Polls to PollResponses containing vote counts and poll creator details
//        List<Long> pollIds = products.map(Product::getId).getContent();
//        Map<Long, Long> choiceVoteCountMap = getChoiceVoteCountMap(pollIds);
//        Map<Long, Long> pollUserVoteMap = getPollUserVoteMap(currentUser, pollIds);
//        Map<Long, User> creatorMap = getPollCreatorMap(polls.getContent());

//        List<ProductResponse> pollResponses = polls.map(poll -> {
//            return ModelMapper.mapPollToPollResponse(poll,
//                    choiceVoteCountMap,
//                    creatorMap.get(poll.getCreatedBy()),
//                    pollUserVoteMap == null ? null : pollUserVoteMap.getOrDefault(poll.getId(), null));
//        }).getContent();

        List<Product> productResponses = new ArrayList<Product>(); 
        products.forEach(pr -> {
            productResponses.add(pr);
        });
        
        return new PagedResponse<Product>(productResponses, products.getNumber(),
                products.getSize(), products.getTotalElements(), products.getTotalPages(), products.isLast());
    }
    
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    
    public Product addProduct(Product prod) {
        System.out.println("ProductService.addProduct()===" + prod.getName());
        Product pr = productRepository.save(prod);
        return pr;
    }
    
    private void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }
}
