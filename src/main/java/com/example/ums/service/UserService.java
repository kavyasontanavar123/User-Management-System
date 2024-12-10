package com.example.ums.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ums.entity.User;
import com.example.ums.exception.UserNotFoundByIdException;
import com.example.ums.repository.UserRepository;


@Service
public class UserService {
	private final UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
		
	}

	public void deleteUser(int id) {
		User user = this.findUser(id);
		 userRepository.delete(user);
		
	}

	public User findUser(int id) {
		
		return userRepository.findById(id)
				.orElseThrow(()-> new UserNotFoundByIdException("failed to found user By id","display-users"));
	
//
//	Optional<User> optional = userRepository.findById(id);
//	
//	if(optional.isPresent()) {
//		return optional.get();
//	}else {
//		//throw new UserNotFounByIdException();
//		return null;
//	}
	}
	public void editUser(User user) {
		this.findUser(user.getId());// confirms that user is present or not
		userRepository.save(user);
		
	}
	

}
