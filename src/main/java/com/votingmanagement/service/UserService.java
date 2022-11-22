package com.votingmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votingmanagement.exception.DuplicateException;
import com.votingmanagement.exception.InvalidElectionCardException;
import com.votingmanagement.exception.VoterNotFoundException;
import com.votingmanagement.model.User;
import com.votingmanagement.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	public String deleteUser(Long userId) throws VoterNotFoundException {
		
		Optional<User> findUser = (userRepository.findById(userId));
		
		if(!findUser.isPresent()) {
			throw new VoterNotFoundException(" User not found");
		}
		else {
		userRepository.deleteById(userId);
		return "User successfully deleted";
		}
		
	}
	
	  public List<User> getAllUser() {
	        return userRepository.findAll();
	    }
	  
	  public User updateUser(Long userId, User user)throws VoterNotFoundException {
		  Optional<User> findVoter = userRepository.findById(userId);
		  if (!findVoter.isPresent())
			  throw new VoterNotFoundException("User not found");
		  
		  User getUserById = userRepository.findById(userId).get();
//		  	getUserById.setElectionCard(user.getElectionCard());
		  	getUserById.setAddress(user.getAddress());
		  	getUserById.setUserContact(user.getUserContact());
		  	getUserById.setUsername(user.getUsername());
		  	
		  return userRepository.saveAndFlush(getUserById);
	  }
}
