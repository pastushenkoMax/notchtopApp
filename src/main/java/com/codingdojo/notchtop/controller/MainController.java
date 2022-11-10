package com.codingdojo.notchtop.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.notchtop.models.Admin;
import com.codingdojo.notchtop.models.LoginAdmin;
import com.codingdojo.notchtop.service.AdminService;
import com.codingdojo.notchtop.service.PostService;

@Controller
public class MainController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private PostService postService;
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {  
		if (session.getAttribute("id") != null) {
			return "redirect:/admin_page";
			}else {
				model.addAttribute("posts", postService.findAll());
				return "index";
				}
		}
	
	@GetMapping("/login")
	public String login(Model model, HttpSession session) {  
		if (session.getAttribute("id") != null) {
			return "redirect:/admin_page";
			}else {
				model.addAttribute("createLogin", new LoginAdmin());
				return "login";
				}
		}
	
	@GetMapping("/admin_page")
	public String profilePage(Model model, HttpSession session) {
		if (session.getAttribute("id") == null) {
			return "redirect:/";
		}
		model.addAttribute("posts", postService.findAll());
		return "adminPage";
	}
		
	@PostMapping("/login_user")
	public String loginUser( 
			@Valid @ModelAttribute("createLogin") LoginAdmin createLogin, BindingResult result, 
			Model model, HttpSession session) {
		Admin logUser = adminService.loginAdmin(createLogin, result);
		if(result.hasErrors()) {
	        return "login";
	        }
	    session.setAttribute("id", logUser.getId());
	    return "redirect:/admin_page";
	    }
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.setAttribute("id", null);
	    return "redirect:/";
	    }

}
