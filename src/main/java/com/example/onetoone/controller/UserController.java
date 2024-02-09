package com.example.onetoone.controller;

import com.example.onetoone.model.Product;
import com.example.onetoone.model.User;
import com.example.onetoone.repo.ProductRepo;
import com.example.onetoone.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
      userRepo.save(user);
      return user;

    }

    @GetMapping("/getUserByProductId/{id}")
    public User getUserByProductId(@PathVariable int id){
        Product product = productRepo.findById(id).get();
//        return userRepo.findById(product.getUser().getUserId()).get();
        return product.getUser();

    }
}
