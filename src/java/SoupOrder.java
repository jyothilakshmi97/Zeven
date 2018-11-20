/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/SoupOrder"})
public class SoupOrder extends HttpServlet {

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
            HttpSession session=request.getSession();
                
                
                if(request.getParameter("chvegcheck")!=null){
                int q1=Integer.parseInt(request.getParameter("q1"));
                String i1=request.getParameter("chvegcheck");
                int t1=Integer.parseInt(request.getParameter("t1"));
                session.setAttribute("Item1",i1);
                session.setAttribute("Quantity1",q1);
                session.setAttribute("Total1",t1); 
                }
     
               if(request.getParameter("eggcheck")!=null){ 
               int q2=Integer.parseInt(request.getParameter("q2"));
               String i2=request.getParameter("eggcheck");
               int t2=Integer.parseInt(request.getParameter("t2"));
               session.setAttribute("Item2",i2);
                session.setAttribute("Quantity2",q2);
                session.setAttribute("Total2",t2);
               }
            
               
               if(request.getParameter("sweetcheck")!=null){
               int q3=Integer.parseInt(request.getParameter("q3"));
                String i3=request.getParameter("sweetcheck");
                int t3=Integer.parseInt(request.getParameter("t3"));
                session.setAttribute("Item3",i3);
                session.setAttribute("Quantity3",q3);
                session.setAttribute("Total3",t3);
               }
           
               if(request.getParameter("mushcheck")!=null){
               int q4=Integer.parseInt(request.getParameter("q4"));
                String i4=request.getParameter("mushcheck");
                int t4=Integer.parseInt(request.getParameter("t4"));
                 session.setAttribute("Item4",i4);
                session.setAttribute("Quantity4",q4);
                session.setAttribute("Total4",t4);
               }
            
                if(request.getParameter("carrotcheck")!=null){
                int q5=Integer.parseInt(request.getParameter("q5"));
                String i5=request.getParameter("carrotcheck");
                int t5=Integer.parseInt(request.getParameter("t5"));
                 session.setAttribute("Item5",i5);
                session.setAttribute("Quantity5",q5);
                session.setAttribute("Total5",t5);
                }
                
            
               if(request.getParameter("bergcheck")!=null){
                int q6=Integer.parseInt(request.getParameter("q6"));
                String i6=request.getParameter("bergcheck");
                int t6=Integer.parseInt(request.getParameter("t6"));
                session.setAttribute("Item6",i6);
                session.setAttribute("Quantity6",q6);
                session.setAttribute("Total6",t6);
               }
            
            if(request.getParameter("tomatocheck")!=null){
                int q7=Integer.parseInt(request.getParameter("q7"));
                String i7=request.getParameter("tomatocheck");
                int t7=Integer.parseInt(request.getParameter("t7"));
                session.setAttribute("Item7",i7);
                session.setAttribute("Quantity7",q7);
                session.setAttribute("Total7",t7);
            }
                 
            int tcost=Integer.parseInt(request.getParameter("total"));
            session.setAttribute("Total",tcost);           
                
               
               
                
               
            
            
             response.sendRedirect("Billing.html");
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
