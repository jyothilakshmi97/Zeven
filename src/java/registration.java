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
 * @author KHSCI5MCA16089
 */ 
@WebServlet(urlPatterns = {"/registration"})
public class registration extends HttpServlet {

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
            
            String fname=request.getParameter("fname");
            String lname=request.getParameter("lname");
            String uname=request.getParameter("username");
            String pass=request.getParameter("password");
            String email=request.getParameter("email");
            String phone=request.getParameter("phone");        
            
             
            
                
                    
                  
                        try{
                    
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zeven","root","");
                
                
                            PreparedStatement ps=con.prepareStatement("insert into userdetails values(?,?,?,?,?,?)");
                     
                            ps.setString(1,fname);
                            ps.setString(2,lname);
                            ps.setString(3,uname);
                            ps.setString(4,pass);
                            ps.setString(5,email);
                            ps.setString(6,phone);
                     
                            ps.executeUpdate();
                    
                            con.close();
                            out.println("<script type=\"text/javascript\">");  
                            out.println("alert('Succefully Signed Up');");  
                            out.println("</script>");
                            response.sendRedirect("CuisineSelect.html");
                
                
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
