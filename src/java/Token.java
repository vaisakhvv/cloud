/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author acute
 */

@WebServlet(name = "Token", urlPatterns = {"/Token"})
public class Token extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    try {
            String name     = request.getParameter("name");
            String Token    = request.getParameter("token");                       
           
              // JOptionPane.showMessageDialog(null,"Yess");         
               
          try{                 
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                
                Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\VIMPLES\\SQLEXPRESS:1433;databaseName=KDC_1","vaisakh","vaisakh44");
                
                Statement stmt = con.createStatement(); 
                
                stmt.executeUpdate("insert into kdc1 values('"+name+"','"+Token+"')");            
              }                      
                catch(Exception e)
                {                    
                    System.out.println(e);
                }   
          
          try
            {                 
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                
                Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\VIMPLES\\SQLEXPRESS:1433;databaseName=KDC_2","vaisakh","vaisakh44");
                
                Statement stmt = con.createStatement(); 
                
                stmt.executeUpdate("insert into kdc2 values('"+name+"','"+Token+"')");
            
                JOptionPane.showMessageDialog(null,"Registered Successfully");               
                {
                    // JOptionPane.showMessageDialog(null,"Registered Successfully");                    
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");                    
                    rd.forward(request,response);                        
                }
            }                      
                catch(Exception e)
                {
                    
                    System.out.println(e);
                }   
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Token</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Token at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
    public String getServletInfo() 
    {
        return "Short description";
    }// </editor-fold>
}