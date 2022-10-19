package com.codingdojo.notchtop.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.codingdojo.notchtop.models.Post;
import com.codingdojo.notchtop.repository.PostRepositorry;



@Service
public class PostService {
    
	@Autowired
    private PostRepositorry pRepository;
    public  PostService(PostRepositorry pRepository) {
		this.pRepository = pRepository;
    }
    
    public Post createNewPost(@Valid Post post, MultipartFile file, BindingResult result) {
    	if(result.hasErrors()) {
    		return null;
    		}else {
    			post.setFileName(file.getOriginalFilename());
    			return pRepository.save(post);
    		}
		}
    
    public Post updatePost(@Valid Post post, String fileName, BindingResult result) {
    	if(result.hasErrors()) {
    		return null;
    		}else {
    			post.setFileName(fileName);
    			return pRepository.save(post);
    		}
		}
    
    public Post updatePost(@Valid Post post, BindingResult result) {
    	if(result.hasErrors()) {
    		return null;
    		}else {
    			return pRepository.save(post);
    		}
		}

	public Post findPostByID(Long id) {
		Optional<Post> post = pRepository.findById(id);
    	if(post.isPresent()) {
    		return post.get();
    		} else {
    			return null;
    			}
	}

	public void deletePost(Long id) {
		pRepository.deleteById(id);
	}

	public List<Post> findAll() {
		return pRepository.findAll();
	}
	
	public List<Post> findAllPostByID(Long id) {
		return pRepository.findAllById(id);
	}
}
