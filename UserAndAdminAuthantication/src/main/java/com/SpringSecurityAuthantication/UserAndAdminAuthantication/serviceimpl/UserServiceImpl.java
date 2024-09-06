package com.SpringSecurityAuthantication.UserAndAdminAuthantication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringSecurityAuthantication.UserAndAdminAuthantication.pojo.User;
import com.SpringSecurityAuthantication.UserAndAdminAuthantication.repository.UserRepository;
import com.SpringSecurityAuthantication.UserAndAdminAuthantication.service.UserService;
import com.SpringSecurityAuthantication.UserAndAdminAuthantication.util.GenricResponse;




//@Service class as a Spring service for automatic detection and registration.
@Service
public class UserServiceImpl implements UserService {
	
	  @Autowired
	    private UserRepository userRepository;
	    // Automatically injects an instance of UserRepositry into this class

	 
	    @Override
	    public ResponseEntity<?> addUserDetails(User user) {
	        // Implements the addUserDetails method from the LoginServices interface

	        // Extract the email from the User object
	        String email = user.getEmail();

	        // Fetch the user from the repository by email
	        User user1 = userRepository.findByEmail(email);

	        // Check if the user with the given email already exists
	        if (user1 == null) {
	            // If the user does not exist, save the new user to the repository
	            userRepository.save(user);

	           
	          
	            // Return a success response with HTTP status 201 (Created) and the new user details
	            return ResponseEntity.ok(new GenricResponse(201, "Success", user));
	        } else {
	            // If the user already exists, return a response indicating that the email is already in use
	            return ResponseEntity.ok(new GenricResponse(203, "Sorry Email id already exist", null));
	        }
	    }

	
}
