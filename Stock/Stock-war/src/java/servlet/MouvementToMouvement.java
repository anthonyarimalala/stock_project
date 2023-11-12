/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.BeanInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import magasin.Stock;
import stock.Mouvement;
import bean_stock.BeanStockInterface;

public class MouvementToMouvement extends HttpServlet {

    @EJB
    BeanInterface bi;
    
    @EJB
    BeanStockInterface bsi;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
                String string_id_stock = request.getParameter("id_stock");
                int id_stock = Integer.parseInt(string_id_stock);
                
                Stock s = bi.selectStock(id_stock);
                
                String string_date_mouvement = request.getParameter("date_mouvement");
                String string_mouvement = request.getParameter("mouvement");
                
                String type = request.getParameter("type");
                Timestamp date_mouvement = null;
                float mouvement = Float.parseFloat(string_mouvement);
                float prix_u = s.getPrixUnitaire();
                float quantite = s.getQuantite();
                
                
                
                
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                    Date parsedDate = dateFormat.parse(string_date_mouvement);
                    date_mouvement = new Timestamp(parsedDate.getTime());

                } catch (ParseException e) {
                    e.printStackTrace(); // Gérer les erreurs de conversion
                }
                Mouvement mv = bsi.buildMouvement(type, date_mouvement, id_stock, prix_u, mouvement, prix_u, quantite);
                out.println(bsi.insererMouvement(mv));
                
                
                
                response.sendRedirect("HeaderToMouvement");
            }catch(Exception e){
                e.printStackTrace(out);
            }
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
