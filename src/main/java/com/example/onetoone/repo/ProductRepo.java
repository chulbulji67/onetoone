package com.example.onetoone.repo;

import com.example.onetoone.model.Product;
import com.example.onetoone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
//    List<Product> findByUser(Optional<User> byId);
}
