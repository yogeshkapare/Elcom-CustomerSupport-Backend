package com.eipl.customersupport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eipl.customersupport.models.Userlogindetails;
import com.eipl.customersupport.repository.UserlogindetailsRepository;

@RestController
@RequestMapping("/api/userlogindetails")
public class userlogindetailsController {

	@Autowired
	private UserlogindetailsRepository  userlogindetailsRepository;
	
    @GetMapping("/all")
    public List<Userlogindetails> getAllUserlogindetails() {
        return userlogindetailsRepository.findAll();
    }	
}
