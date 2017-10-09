package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.Service;

@WebServlet("/update")
public class UpdateReimbursementsServlet {

  private static final ServletRequest reg = null;

  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
    System.out.println("posting new Reimbursement to db");
   
    HttpSession session = req.getSession(false);
    if(session != null){
     System.out.println("session is valid");
      
      Service remService = new Service();

    User user = (User) session.getAttribute("user");
    
    String s = session.toString();
    System.out.println(s); 
   
    Reimbursement newReimbursement = new Reimbursement();
    ArrayList<Reimbursement> someRembur = new ArrayList<>(); 
    
//    for(int i = 0; i < session.; i++){
//      newReimbursement.setStatusID(new Integer (reg.getParameter("statusID")));
//      newReimbursement.setResolvedNote(req.getParameter("resolvedNote"));
//      
//      someRembur.add(newReimbursement);
//    }
    
    
  newReimbursement.setResolvedNote(req.getParameter("resolvedNote"));
  String test =  newReimbursement.getResolvedNote();//testing
   System.out.println(test);
    newReimbursement.setStatusID(new Integer (reg.getParameter("statusID")));
  
   //System.out.println(joshmoney + " " + id + "" + test);
   remService.updateRiembursments(someRembur);

   

    session.setAttribute("user", user);
    session.setAttribute("newrem", remService);
// need to change this
    req.getRequestDispatcher("partials/dashboard.html").forward(req, res);
    }
 
   
   
    
    
    }

  
  
  
  }
  
  
  
  
