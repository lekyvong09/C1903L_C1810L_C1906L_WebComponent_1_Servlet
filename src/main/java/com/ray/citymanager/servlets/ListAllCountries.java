package com.ray.citymanager.servlets;

import com.ray.citymanager.models.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "ListAllCountries", value = "/ListAllCountries")
public class ListAllCountries extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get the DBManager from context
        DBManager dbm = (DBManager)getServletContext().getAttribute("WorldDBManager");

        //generate the output in a StringBuilder
        StringBuilder sb = new StringBuilder("<html><body>");

        try
        {
            //connect to the db and open the connection
            if (!dbm.isConnected())
            {
                if (!dbm.openConnection())
                {
                    sb.append("Could not connect to database");
                }
            }

            sb.append("<table border=1>"
                    + "<tr><td>Code</td><td>Name</td><td>Population</td></tr>");

            String query =  "select Code, Name, Population from country order by Name";
            ResultSet rs = dbm.ExecuteResultSet(query);

            while (rs.next())
            {
                String id = rs.getString("Code");
                String name = rs.getString("Name");
                int pop = rs.getInt("population");

                sb.append("<tr><td>" + id + "</td>"
                        + "<td>" + name + "</td>"
                        + "<td>" + pop + "</td></tr>");
            }
            sb.append("</table>");
        }
        catch (Exception e)
        {
            sb.append("<h1>Error: " + e.getMessage() + "</h1>");
        }
        sb.append("</body></html>");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(sb);
    }

}
