package com.codingdojo.notchtop.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.notchtop.models.Admin;



@Repository
public interface AdminRepositorry extends CrudRepository<Admin, Long> {
 
 Optional<Admin> findByUserName(String userName);
 
}
