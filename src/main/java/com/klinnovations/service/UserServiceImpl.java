package com.klinnovations.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klinnovations.entity.User;
import com.klinnovations.exception.UserAlreadyExistByException;
import com.klinnovations.exception.UserNotFoundException;
import com.klinnovations.repo.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		if(userRepository.existsById(user.getId())) {
			throw  new UserAlreadyExistByException("User Already Exist With id : " + user.getId());
		}
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		if(!userRepository.existsById(user.getId())) {
			throw new UserNotFoundException("User not found Exception : "+ user.getId());
		}
		return userRepository.save(user);
	}
	public User deleteUser(int id) {
		User UserToDelet = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user not found exception with id :"+id));
		userRepository.delete(UserToDelet);
		return UserToDelet;
	}
	public List<User> getAllUser(){
		return userRepository.findAll();
	}

}
	

