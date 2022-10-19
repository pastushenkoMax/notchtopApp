package com.codingdojo.notchtop.controller;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.codingdojo.notchtop.models.Post;
import com.codingdojo.notchtop.service.PostService;
import com.codingdojo.notchtop.service.S3Service;


@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private S3Service s3Service;
	
	@GetMapping("/addPost")
	public String addPost(
			Model model,
			@ModelAttribute("createPost")Post createPost,
			HttpSession session) {
		if (session.getAttribute("id") == null) {
			return "redirect:/login";
			}else {
				model.addAttribute("admin_id", (Long)session.getAttribute("id"));
				return "addPost.jsp";
				}
		}
	
	@PostMapping("/newPost")
	public String new_post(Model model,@ModelAttribute("createPost")Post createPost, 
			@ModelAttribute("imageFile")MultipartFile imageFile,
			BindingResult result, HttpSession session) {
		if (session.getAttribute("id") == null) {
			return "redirect:/login";
			}else {
				if(result.hasErrors()) {
					return "addPost.jsp";
				}
				if(imageFile.isEmpty()) {
					return "addPost.jsp";
				}else {
					postService.createNewPost(createPost, imageFile, result);
					s3Service.saveFile(imageFile);
					return "redirect:/";
					}
				}
		}
	
	@GetMapping("/post/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model,
			@ModelAttribute("editPost")Post editPost, HttpSession session) {
		if (session.getAttribute("id") == null) {
			return "redirect:/login";
			} else {
				Post p = postService.findPostByID(id);
				model.addAttribute("admin_id", (Long)session.getAttribute("id"));
				model.addAttribute("post", p);
				return "editPost.jsp";
				}
		}
	
	@PutMapping("/post/{id}/update")
	public String updatePost(@PathVariable("id") Long id,Model model,
			@Valid @ModelAttribute("editPost") Post editPost,
			@ModelAttribute ("imageFile")MultipartFile imageFile,
			BindingResult result, HttpSession session)  {
		if (session.getAttribute("id") == null) {
			return "redirect:/login";
			} else {
				if(result.hasErrors()) {
					return "redirect:/post/{id}/edit";
				}
				Post p = postService.findPostByID(id);
				if(imageFile.isEmpty()) {
					String fileName = p.getFileName();
					postService.updatePost(editPost, fileName, result);
					}else {	
						s3Service.deleteFile(p.getFileName());
						postService.createNewPost(editPost, imageFile, result);
						s3Service.saveFile(imageFile);
					}
				return "redirect:/";
				}
		}
	
	@RequestMapping(value="/post/delete/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("id") == null) {
			return "redirect:/login";
			} else {
				Post filename = postService.findPostByID(id);
				s3Service.deleteFile(filename.getFileName());
				postService.deletePost(id);
				return "redirect:/";
				}
		}
	
	}

