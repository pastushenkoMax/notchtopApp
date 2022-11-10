package com.codingdojo.notchtop.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.notchtop.models.Admin;
import com.codingdojo.notchtop.models.LoginAdmin;
import com.codingdojo.notchtop.repository.AdminRepositorry;

@Service
public class AdminService {
	@Autowired
    private AdminRepositorry aRepository;
    public AdminService(AdminRepositorry aRepository) {
		this.aRepository = aRepository;
    }
    
//    public Admin registerAdmin(Admin createUser, BindingResult result) {
//    	    	
//    	if(!createUser.getPassword().equals(createUser.getConfirm())) {
//    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
//    	}
//    	if(result.hasErrors()) {
//    		return null;
//    	}
//    	String upercase_name = createUser.getUserName().toUpperCase();
//    	createUser.setUserName(upercase_name);
//    	String hashed = BCrypt.hashpw(createUser.getPassword(), BCrypt.gensalt());
//    	createUser.setPassword(hashed);
//		return aRepository.save(createUser);
//    	
//    }
    
    public Admin loginAdmin(LoginAdmin logUser, BindingResult result) {
        
    	Optional<Admin> tempUser = aRepository.findByUserName(logUser.getUserName().toUpperCase());
    	if(result.hasErrors()) {
    		return null;
    	}
    	if(!tempUser.isPresent()) {
    		result.rejectValue("userName", "Matches", "User not exist!");
    		return null;
    	}
    	if(!BCrypt.checkpw(logUser.getPassword(), tempUser.get().getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid Password!");
    		return null;
    	}
    	
    	return tempUser.get();
    }
}
