
package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.DTO;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.Service;

@WebServlet("/getRemId")
public class GetRemByRemIdServlet extends HttpServlet {

  
  //protected String servletConfigParam = null;
  
//  static Service service = new Service();
//  
//  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    System.out.println("posting new Reimbursement to db");
//    
//    HttpSession session = request.getSession(false);
//    if(session != null){
//     System.out.println("session is valid");
//         //int sessionRem = (int)session.getAttribute("reimbursement");// not sure what we are passing in here
//  // Trying to pass reimbursement id to database to retrive 
//    service.getReimbursement(sessionRem);
//    session.setAttribute("user", u);
//    
//    ArrayList<Reimbursement> someRembur = new ArrayList<>(); 
//    someRembur = service.getUserRemibursements(sessionUser);
//
//    DTO dto = new DTO(sessionUser, someRembur);
//    ObjectMapper mapper = new ObjectMapper();
//
//    String json = mapper.writeValueAsString(dto);
//
//    PrintWriter out = response.getWriter();
//    response.setContentType("application/json");
//    out.write(json);
//  
//      
//  }
  
}