package com.revature.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.User;

public class DAOimpTest {
  int myUserId;
  User myBob;
   DAOUser myTest;
	@Before
	public void setUp() throws Exception {
	 myUserId = 1;
	 myBob = new User();
	 myTest = new DAOUser();
	  
	}

	@Test
	public void getIdTest() {
	
	User	actual = myTest.getUserById(myUserId); 
	myBob.setUserId(1);
	      assertEquals(myBob , actual);
	}

}
