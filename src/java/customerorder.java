/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PraveenPi
 */
@WebServlet(urlPatterns = {"/customerorder"})
public class customerorder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0, shrink-to-fit=no'>");
            out.println("<title>customer detials</title>");
            out.println("<link rel='stylesheet' href='assets/bootstrap/css/bootstrap.min.css'>");
            out.println("<link rel='stylesheet' href='assets/css/styles.css'>");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<div class='table-responsive'>");
            out.println("<table class='table'>");
            out.println("<thead>");
                out.println("<tr>");
                    out.println("<th>Item 1</th>");
                    out.println("<th>Item 2</th>");
                    out.println("<th>Item 3</th>");
                    out.println("<th>Item 4</th>");
                    out.println("<th>Item 5</th>");
                    out.println("<th>Item 6</th>");
                    out.println("<th>Item 7</th>");
                    out.println("<th>Total</th>");
                    out.println("<th>Name</th>");
                    out.println("<th>Email</th>");
                    out.println("<th>Address</th>");
                    out.println("<th>Phone</th>");
                out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
                out.println("<tr></tr>");
                out.println("<tr></tr>");
            
              try{
               
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zeven","root","123");
               
               
                     //PreparedStatement ps=con.prepareStatement("select username,password from userdetails where username=? and password=?");
                     PreparedStatement ps=con.prepareStatement("select*from orders");
                    
                     ResultSet rs=ps.executeQuery();
               
                    while(rs.next()){
                        
                            
                        for (int i=1; i<2; i++) {
                        out.println("<tr>");  
                            out.println("<td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td>"
                                    + "<td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td>"
                                            + "<td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td>"+rs.getString(12)+"</td>");
                        }
                        out.println("</tr>");
                    }
                   
                          
                    out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("<script src='assets/js/jquery.min.js'></script>");
            out.println("<script src='assets/bootstrap/js/bootstrap.min.js'></script>");
            out.println("</body>");
                    
                    
                    return;
                }catch(Exception e){out.println(e);} 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
