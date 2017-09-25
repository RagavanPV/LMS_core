package com.revature.controller;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.UserServiceImpl;
import com.revature.data.exception.DataServiceException;
import com.revature.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl user;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> userList=null;
		ResponseEntity<List<User>> entity=new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		try {
			userList= user.getAllUsers();
			entity=new ResponseEntity<>(userList, HttpStatus.OK);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return entity;
		
	}
	@PostMapping("/GetUser")
	public ResponseEntity<List<User>> getUser(@RequestBody User details) {
		List<User> userList=null;
		ResponseEntity<List<User>> entity=new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		try {
			userList= user.getUser(details.getEmailId(),details.getUserPassword());
			entity=new ResponseEntity<>(userList, HttpStatus.OK);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return entity;
		
	}

    @GetMapping("/forgotpassword")
    public Integer forgotPassword(@RequestParam("emailid") String emailid) {
        User users=new User();
        Integer rows = null;
        users.setEmailId(emailid);
        try {
        rows=user.forgotPassword(users);
        } catch (DataServiceException e) {
            e.printStackTrace();
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rows;

    }
    @GetMapping("/verifycode")
    public List<User> verifyCode(@RequestParam("emailid") String emailid,@RequestParam("code") String actcode) {
        User users=new User();
        List<User> rows = null;
        users.setEmailId(emailid);
        users.setActivationCode(actcode);
        try {
        rows=user.checkActivation(users);
        } catch (DataServiceException e) {
            e.printStackTrace();
        }
        return rows;

    }
    @PostMapping("/updatepassword")
    public Integer updatePassword(@RequestBody User u) {
        User use = new User();
        logger.info("Adding employee data");
        try {
            
           use.setEmailId(u.getEmailId());
           use.setUserPassword(u.getUserPassword());
           return user.updatePassword(use);
        } catch (DataServiceException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}