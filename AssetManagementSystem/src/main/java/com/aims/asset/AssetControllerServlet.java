package com.aims.asset;
import java.util.List;

import javax.sql.DataSource;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class AssetControllerServlet
 */

@WebServlet("/AssetControllerServlet")
public class AssetControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AssetDbUtil assetDbUtil;

	@Resource(name="jdbc/web_asset_tracker")
	private DataSource datasource ;
	
	
    /**
     * Default constructor. 
     */
    public AssetControllerServlet() {
        // TODO Auto-generated constructor stub
    }
    
    // implement init method
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	
    	//create dbu objects
     try {
    	 
    	 assetDbUtil = new AssetDbUtil(datasource);
    	 
    	 
     }catch(Exception exc) {
    	 throw new ServletException();
     }
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // implement try catch
		
		try {
		
		// create string to store the parameter from our jsp page
		 String theCommand = request.getParameter("command");
			
		// create an if statement to check whether parameter is missing, then default
		 
		 if(theCommand == null) {
			 theCommand="List";
		 }
		
		// create switch case or route
		 
		 switch(theCommand) {
		 
		 case "List":
			 listComputer(request, response);
			 break;
		 
		 default:
			 listComputer(request, response);
		    
		 }
		
		}catch(Exception exc) {
			throw new ServletException();
		}
		
		
	}

	private void listComputer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		   // declare a variable of type bean and call the method getComputers
		      List<Computer> comp = assetDbUtil.getComputers();
		    
		      //set Attribute
		      
		      request.setAttribute("COMPUTER_LIST", comp);
		   // direct to jsp page
		      
		      RequestDispatcher dispatcher = request.getRequestDispatcher("/list-computers.jsp");
		      dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
