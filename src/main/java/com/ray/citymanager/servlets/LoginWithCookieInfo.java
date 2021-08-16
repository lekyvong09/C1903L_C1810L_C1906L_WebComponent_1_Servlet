package com.ray.citymanager.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/loginwithcookieinfo.do")
public class LoginWithCookieInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginWithCookieInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = "";
		String pwd = "";
		
		Cookie[] MyCookies = request.getCookies();
		if (MyCookies != null) {
			for (Cookie c : MyCookies) {
				if (c.getName().equalsIgnoreCase("credentials_uid"))
					uid = c.getValue();
				if (c.getName().equalsIgnoreCase("credentials_pwd"))
					pwd = c.getValue();
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		sb.append("<html><body>");
		sb.append("<form id='frmLogin' name='frmLogin' action='userlogincookies.do' method='post'>");
		sb.append("<table>");
		sb.append("<tr><td><span>Username:</span></td><td><input type='text' name='userID' value='"+ uid + "'/></td></tr>");
		sb.append("<tr><td><span>Password:</span></td><td><input type='password' name='pwd' value='"+ pwd + "'/></td></tr>");
		sb.append("<tr><td colspan='2'align='right'><input type='checkbox' name='remember' />Remember Me</td></tr>");
		sb.append("<tr><td colspan='2'align='right'><input type='submit' name='loginbutton' value='Log In'/></td></tr>");
		sb.append("</table>");
		sb.append("</form>");
		sb.append("</body></html>");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
	}

}
