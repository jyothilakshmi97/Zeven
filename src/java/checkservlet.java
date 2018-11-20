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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PraveenPi
 */
@WebServlet(urlPatterns = {"/checkservlet"})
public class checkservlet extends HttpServlet {

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
          
            
           HttpSession session=request.getSession(false);  

                 
                String item1=(String)session.getAttribute("Item1");
                Integer qty1=(Integer)session.getAttribute("Quantity1");
                Integer tot1=(Integer)session.getAttribute("Total1");
                String item2=(String)session.getAttribute("Item2");
                Integer qty2=(Integer)session.getAttribute("Quantity2");
                Integer tot2=(Integer)session.getAttribute("Total2");
                String item3=(String)session.getAttribute("Item3");
                Integer qty3=(Integer)session.getAttribute("Quantity3");
                Integer tot3=(Integer)session.getAttribute("Total3");
                String item4=(String) session.getAttribute("Item4");
                Integer qty4=(Integer)session.getAttribute("Quantity4");
                Integer tot4=(Integer)session.getAttribute("Total4");
                String item5=(String) session.getAttribute("Item5");
                Integer qty5=(Integer)session.getAttribute("Quantity5");
                Integer tot5=(Integer)session.getAttribute("Total5");
                String item6=(String) session.getAttribute("Item6");
                Integer qty6=(Integer) session.getAttribute("Quantity6");
                Integer tot6=(Integer)session.getAttribute("Total6");
                String item7=(String) session.getAttribute("Item7");
                Integer qty7=(Integer)session.getAttribute("Quantity7");
                Integer tot7=(Integer)session.getAttribute("Total7");
                Integer total=(Integer)session.getAttribute("Total");
               
                
                String fitem1= item1+" "+qty1+" "+ tot1;
                String fitem2= item2+" "+ qty2+" "+tot2;
                String fitem3= item3+" "+qty3+" "+tot3;
                String fitem4= item4+" "+qty4+" "+tot4;
                String fitem5= item5+" "+qty5+" "+tot5;
                String fitem6= item6+" "+qty6+" "+tot6;
                String fitem7= item7+" "+qty7+" "+tot7;
                String Total = ""+ total;
                String name=request.getParameter("name");
                String email=request.getParameter("email");
                String address=request.getParameter("address");
                String phone=request.getParameter("phone");
              
              try{
                    Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zeven","root","123");
                
                
                            PreparedStatement ps=con.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?,?,?,?,?)");
                     
                            ps.setString(1,fitem1);
                            ps.setString(2,fitem2);
                            ps.setString(3,fitem3);
                            ps.setString(4,fitem4);
                            ps.setString(5,fitem5);
                            ps.setString(6,fitem6);
                            ps.setString(7,fitem7);
                            ps.setString(8,Total);
                            ps.setString(9,name);
                            ps.setString(10,email);
                            ps.setString(11,address);
                            ps.setString(12,phone);
                            
                            ps.executeUpdate();
                    
                            con.close();
                            
                            
                            
                            response.sendRedirect("success.html");
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
