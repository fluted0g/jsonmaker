/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.control;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.Table;

/**
 *
 * @author rafael aznar
 */
public class Control extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
            throws ServletException, IOException, Exception {

        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("ob") != null) {
                if (request.getParameter("op") != null) {
                    if (request.getParameter("ob").equals("table")) {
                        if (request.getParameter("op").equals("get")) {
                            response.setContentType("application/json;charset=UTF-8");
                            JsonMaker oJsonmaker = new JsonMaker();
                            int ancho = RandomGenerator.randInt(3, 13);
                            int alto = RandomGenerator.randInt(3, 20);
                            Table t = oJsonmaker.getTable(ancho, alto);
                            Gson gson = JsonGson.getGson();
                            String data = JsonGson.getJson("200", gson.toJson(t));
                            out.print(data);
                            out.flush();
                        }
                    }
                }
            } else {
                getServletContext().getRequestDispatcher("/index.html").forward(request, response);
            }
        } catch (Exception ex) {
            response.setContentType("application/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(ex.getMessage());
             out.println("--------");
            ex.printStackTrace();
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
