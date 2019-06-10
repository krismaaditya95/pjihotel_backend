package com.mini.project.hotel.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mini.project.hotel.model.Pengguna;
import com.mini.project.hotel.services.UserService;

@RestController
@RequestMapping("/pjihotel/api/v1")
public class UserRESTController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getAllUsers")
	public List<Pengguna> getAllUsers(){
		return userService.getAllPengguna();
	}
	
	@GetMapping("/getUserById/{userId}")
	public Pengguna getUserById(@PathVariable(value = "userId") Integer userId) {
		return userService.getPenggunaById(userId);
	}
	
	@GetMapping("/getUserByUserName/{userName}")
	public Pengguna getUserByUserName(@PathVariable(value = "userName") String userName) {
		return userService.getPenggunaByUserName(userName);
	}
	
	@PostMapping("/login")
	public Boolean login(@Valid @RequestBody String username, String userpass) {
		return userService.login(username, userpass);
	}
	
	@GetMapping("/logout")
	public void logout() {
		userService.logout();
	}
}
