package com.coding.EventBeltReviewer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.EventBeltReviewer.models.EventUser;
import com.coding.EventBeltReviewer.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	public EventUser findById(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	public EventUser registerUser(EventUser user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return this.uRepo.save(user);
	}
	public EventUser getUserByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	public boolean authenticateUser(String email, String password) {
		EventUser user = this.uRepo.findByEmail(email);
		if(user == null)
			return false;
		
		return BCrypt.checkpw(password, user.getPassword());
	}
}