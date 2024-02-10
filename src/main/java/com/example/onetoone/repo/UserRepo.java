package com.example.onetoone.repo;

import com.example.onetoone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
//    User findByProduct(Product product);
}
