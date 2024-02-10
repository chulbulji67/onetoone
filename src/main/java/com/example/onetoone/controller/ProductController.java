package com.example.onetoone.controller;

import com.example.onetoone.exception.UserNotFoundException;
import com.example.onetoone.model.Product;
import com.example.onetoone.model.User;
import com.example.onetoone.repo.ProductRepo;
import com.example.onetoone.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepo userRepo;


    //ADdProduct
    @PostMapping("add")
    public String addProduct(@RequestBody Product product) throws UserNotFoundException {
//        User user = product.getUser();

//       productRepo.save(product);
//        return "added";
        User user = new User();
        if(product.getUser() !=null) {
            user = userRepo.findById(product.getUser().getUserId()).orElse(null);
            if (user == null) {
                throw new UserNotFoundException("User not found with this id");
            }
        }
        else {

               throw new UserNotFoundException("User is null");

        }

        // Set the user for the product
        product.setUser(user);

        // Save the product
        productRepo.save(product);

        return "Product added successfully";
    }

    @GetMapping("/productByuserId/{userId}")
    public Product productsByUserId(@PathVariable int userId){
        User user = userRepo.findById(userId).get();
//        return productRepo.findById(user.getProduct().getProductId()).get();
        return user.getProduct();
    }
}
