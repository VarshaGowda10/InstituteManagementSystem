package com.techpalle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.bean.Student;
import com.techpalle.bean.User;
import com.techpalle.model.Dao;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getServletPath();
		switch(path) {
		case "/reg":registerUser(request,response);
			break;
		case "/log":validateUser(request,response);
			break;
		case "signup":
			break;
		case "/addStudent":
			String action=request.getParameter("action");
			switch(action) {
			case "Add Student":addStudent(request,response);
				break;
			case "Delete":deletionStud(request,response);
				break;
			case "Display":displayStudent(request,response);
				break;
			case "Update":updateStudent(request,response);
				break;
			}
		    break;
		case "/saveStudent":saveStudent(request,response);
		break;
		case "/removeStudent":deletionStudent(request,response);
		break;
		case "/updationStudent":updationStudent(request,response);
		break;
		case"/updatestudentdata":updatestudentdata(request,response);
		break;
		}
		
	}

	private void updatestudentdata(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			String name = request.getParameter("txtname");
			int age = Integer.parseInt(request.getParameter("txtage"));
			long mobile = Long.parseLong(request.getParameter("txtmobile"));
			String address = request.getParameter("txtaddress");
			String email = request.getParameter("txtemail");
			String course = request.getParameter("txtcourse");
			Student s = new Student(name, age, mobile, address, email, course);
			Dao d = new Dao();
			d.updateStudentData(s);
			request.setAttribute("message", "Updated Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	private void updationStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		long mobile=Long.parseLong(request.getParameter("txtmobile"));
		Student s=new  Student(mobile);
		Dao d=new Dao();
		Student s1=d.showStudentData(s);
		if(s1!=null) {
		request.setAttribute("student data", s1);
		RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			request.setAttribute("student data", "Invalid Mobile Number");
			RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.sendRedirect("update.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deletionStud(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.sendRedirect("delete.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void deletionStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		long mobile=Long.parseLong(request.getParameter("txtmobile"));
		Student s=new Student(mobile);
		Dao d=new Dao();
		boolean isMobilePresent=d.deleteStudent(s);
		if(isMobilePresent) {
			request.setAttribute("message","Deleted Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("delete.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				request.setAttribute("display","Student does not exist");
				response.sendRedirect("delete.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	


	private void displayStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Dao d=new Dao();
		d.getData();
		ArrayList<Student> alist=d.getData();
		request.setAttribute("student list", alist);
		RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void saveStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("txtname");
		int age=Integer.parseInt(request.getParameter("txtage"));
		Long mobile=Long.parseLong(request.getParameter("txtmobile"));
		String address= request.getParameter("txtaddress");
        String email= request.getParameter("txtemail");
        String course = request.getParameter("txtcourse");
        Student s=new Student(name,age,mobile,address,email,course);
        Dao d=new Dao();
        boolean isDataPresent=d.insertStudent(s);
        if(isDataPresent) {
        	request.setAttribute("message", "Mobile nbr or Email already exist");
        	RequestDispatcher rd=request.getRequestDispatcher("Student.jsp");
        	try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else {
        	try {
				response.sendRedirect("Student.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	private void addStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
        	try {
				response.sendRedirect("Student.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

	private void validateUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String username=request.getParameter("txtUserName");
		String password=request.getParameter("txtUserPassword");
		User u=new User(username,password);
		Dao d=new Dao();
	    boolean isDataPresent=d.ValidUser(u);
	    if(isDataPresent) {
	    	try {
				response.sendRedirect("home.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    else {
	    	request.setAttribute("message", "User does not exist");
	    	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	    	try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	}
	private void registerUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name=request.getParameter("txtName");
		String email=request.getParameter("txtEmail");
		String password=request.getParameter("txtPassword");
		User u=new User(name,email,password);
		Dao d=new Dao();
		boolean isDataInserted=d.insert(u);
		response.setContentType("text/html");
		PrintWriter out;
		try {
			out = response.getWriter();
			if(isDataInserted) {
				
				response.sendRedirect("login.jsp");
			}
			else {
				request.setAttribute("message", "Email id is Already exist");
				RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
				try {
					rd.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
	


