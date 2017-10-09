package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dto.DTO;
import com.revature.model.Reimbursement;
//import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.Service;
//import com.revature.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet{

  @SuppressWarnings("unused")
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Service service = new Service();

    HttpSession session = request.getSession();
    User sessionUser = (User) session.getAttribute("user");
    System.out.println("GetUserInfoServlet -- GET");
    System.out.println("getting user from session " + sessionUser.toString());



    if(sessionUser != null){
      if(sessionUser.getIsManger() == 0){  

        ArrayList<Reimbursement> someRembur = new ArrayList<>(); 
        someRembur = service.getUserRemibursements(sessionUser);

        DTO dto = new DTO(sessionUser, someRembur);
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(dto);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.write(json);

      } else if(sessionUser.getIsManger() == 1){
        ArrayList<Reimbursement> someRembur = new ArrayList<>(); 
        someRembur = service.getAllRemibursements();

        DTO dto = new DTO(sessionUser, someRembur);
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(dto);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.write(json);

      }    
    } else{
      response.setStatus(418);
    }
  }

}
