/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DAOQuestion;
import dal.DAOUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author duchi
 */
public class HomePageController extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            request.getRequestDispatcher("homepage.jsp").forward(request, response);
            return;
        } else {
            DAOQuestion daoq = new DAOQuestion();
            request.getSession().setAttribute("questions",daoq.getQuestions());
            request.getRequestDispatcher("takequiz.jsp").forward(request, response);
            return;
        }
        
    }

    /**
     * The user logs in to the system first to use the function of each menu
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
        PrintWriter out = response.getWriter();
        JSONArray list = new JSONArray();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "  " + password);
        JSONObject obj = new JSONObject();
        String msg;
        HttpSession session = request.getSession();
        DAOUser daou = new DAOUser();
        if (daou.login(username, password)) {
            User user = daou.getUser();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(3600);
            msg = "1";
            obj.put("msg", msg);
            list.add(obj);
            out.println(list.toJSONString());
            
            out.flush();
            
        } else {
            
            msg = "2";
            obj.put("msg", msg);
            list.add(obj);
            out.println(list.toJSONString());
            
            out.flush();
            
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
