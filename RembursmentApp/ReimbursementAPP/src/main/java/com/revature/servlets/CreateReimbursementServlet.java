package com.revature.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet("/addReimbursement")
public class CreateReimbursementServlet extends HttpServlet{


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
    System.out.println("posting new Reimbursement to db");
   
    HttpSession session = req.getSession(false);
    if(session != null){
     System.out.println("session is valid");
      
      Service remService = new Service();

    User user = (User) session.getAttribute("user");
      
    Reimbursement newReimbursement = new Reimbursement();
    
    newReimbursement.setAmount(new Double(req.getParameter("amount")));
    double joshmoney = newReimbursement.getAmount();//for testing
    
    
    newReimbursement.setDescription(req.getParameter("description"));
  String test =  newReimbursement.getDescription();//testing
   
    newReimbursement.setSubmitterID(user.getUserId());
   int id = newReimbursement.getSubmitterID(); // for testing
   
   System.out.println(joshmoney + " " + id + "" + test);
   remService.addReimbursment(newReimbursement);

   

    session.setAttribute("user", user);
    session.setAttribute("newrem", remService);
// need to change this
 req.getRequestDispatcher("/partials/reimbursement.html").forward(req, res);
    }
 
   
   
    
    
    }

  
  
  
  }







