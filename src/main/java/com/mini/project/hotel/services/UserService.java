package com.mini.project.hotel.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini.project.hotel.model.Pengguna;
import com.mini.project.hotel.repository.PenggunaRepository;
import com.mini.project.hotel.repository.UserRoleRepository;

@Service
public class UserService {
	
	HttpSession session = null;
	
	@Autowired
	PenggunaRepository userRepo;
	
	@Autowired
	UserRoleRepository roleRepo;
	
	public List<Pengguna> getAllPengguna(){
		List<Pengguna> users = userRepo.findAll();
		return users;
	}
	
	public Pengguna getPenggunaById(Integer userId) {
		Pengguna pengguna = userRepo.findByUserId(userId);
		return pengguna;
	}
	
	public Pengguna getPenggunaByUserName(String username) {
		Pengguna pengguna = userRepo.findByUserName(username);
		return pengguna;
	}
	
	public Boolean login(String username, String userpass) {
		
		Pengguna pengguna = userRepo.findByUserName(username);
		
		int idPengguna = pengguna.getUserId();
		String userName = pengguna.getUserName();
		String userPass = pengguna.getUserPass();
		int idUserRole = pengguna.getRole().getIdUserRole();
		String userRoleName = pengguna.getRole().getRoleName();
		
//		for testing
		//Long sessionCreationTime = session.getCreationTime();
		//String sessionId = session.getId();
		//Long lastAccessedTime = session.getLastAccessedTime();
		
		if(username.equalsIgnoreCase(userName) && userpass.equalsIgnoreCase(userPass)) {
			session.setAttribute("idPengguna", idPengguna);
			session.setAttribute("username", userName);
			session.setAttribute("idUserRole", idUserRole);
			session.setAttribute("userRole", userRoleName);
				
//			session.setAttribute("sessionCreationTime", sessionCreationTime);
//			session.setAttribute("sessionId", sessionId);
//			session.setAttribute("lastAccessedTime", lastAccessedTime);
			return true;
		}
		
		return false;
	}
	
	public void logout() {
		session.invalidate();
	}
}
