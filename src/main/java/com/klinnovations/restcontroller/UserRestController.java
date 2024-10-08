package com.klinnovations.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.klinnovations.entity.User;
import com.klinnovations.service.UserServiceImpl;


@RestController
public class UserRestController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/user")
   public ResponseEntity<User> addUser(@RequestBody User user){
		return ResponseEntity.ok(userService.saveUser(user));
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	@PutMapping("/updateuser")
	
	public ResponseEntity<User> updateUser(@RequestBody  User user){
		User updateUser = userService.updateUser(user);
		if(updateUser != null) {
			return ResponseEntity.ok(updateUser);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("deleteuser/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable  int id){

		User deleteUser = userService.deleteUser(id);
		if(deleteUser != null) {
			return ResponseEntity.ok(deleteUser);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
