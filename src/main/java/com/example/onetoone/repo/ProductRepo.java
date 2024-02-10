package com.example.onetoone.repo;

import com.example.onetoone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
//    List<Product> findByUser(Optional<User> byId);
}
