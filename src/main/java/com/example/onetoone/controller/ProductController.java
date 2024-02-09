package com.example.onetoone.controller;

import com.example.onetoone.model.Product;
import com.example.onetoone.model.User;
import com.example.onetoone.repo.ProductRepo;
import com.example.onetoone.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepo userRepo;


    //ADdProduct
    @PostMapping("add")
    public String addProduct(@RequestBody Product product){
//        User user = product.getUser();

       productRepo.save(product);
        return "added";
    }

    @GetMapping("/productByuserId/{userId}")
    public Product productsByUserId(@PathVariable int userId){
        User user = userRepo.findById(userId).get();
//        return productRepo.findById(user.getProduct().getProductId()).get();
        return user.getProduct();
    }
}
