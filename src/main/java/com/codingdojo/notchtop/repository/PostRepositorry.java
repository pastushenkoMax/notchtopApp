package com.codingdojo.notchtop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.notchtop.models.Post;



@Repository
public interface PostRepositorry extends CrudRepository<Post, Long> {
	
	@Query(value = "SELECT * FROM posts ORDER BY id DESC", nativeQuery = true)
	List<Post> findAll();

	@Query(value = "SELECT * FROM posts WHERE user_id = ?1", nativeQuery = true)
	List<Post> findAllById(Long id);	
}

