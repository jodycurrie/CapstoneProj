package com.capstone.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dbtest")
public class DbTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		
		boolean addUser = DbService.AddUser(username);
		
		resp.setContentType("text/html");
		
		PrintWriter htmlOut = resp.getWriter();
		
		htmlOut.println("<html><head><meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
						"<title>CST8288 - Capstone Project Group 2 - FitTrack</title>" + 
						"<link rel='stylesheet' href='style.css'></head><body>");
		
		if (addUser) { 
			
			htmlOut.println("<p>it works</p>");
			
		}else {
			
			htmlOut.println("<p>Didn't work</p>");
		}
		
		
		htmlOut.println("</body></html>");
		
	}

	
	
	
	
}
