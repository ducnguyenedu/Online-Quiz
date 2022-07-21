/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DAOQuestion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Question;
import model.Test;

/**
 *
 * @author duchi
 */
public class TakeQuizController extends HttpServlet {

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
       
        if (session.getAttribute("test") != null) {
            Test test = (Test) session.getAttribute("test");
            int qesIndex = Integer.parseInt(request.getParameter("qesIndex")!=null?request.getParameter("qesIndex"):"0");
            System.out.println(qesIndex);
            String[] answer = request.getParameterMap().get("answer");
            if (answer != null) {
                for (String ans : answer) {
                    System.out.println(ans);
                    test.getUserChoose().add(Integer.parseInt(ans));
                }
            }
            if (qesIndex == test.getQuestions().length) {
                
                double score = test.getScore();
                request.setAttribute("score", score);
                request.setAttribute("percentCorrect", Math.round(score * 10));
                request.setAttribute("isPass", score > 5 ? "Pass" : "Not Pass");
                session.removeAttribute("test");
                request.getRequestDispatcher("score.jsp").forward(request, response);
            } else {
                Question question = test.getQuestions()[qesIndex];
                request.setAttribute("qesIndex", qesIndex);
                request.setAttribute("question", question);
                request.getRequestDispatcher("question.jsp").forward(request, response);
            }
        } else {
            DAOQuestion daoq = new DAOQuestion();
            request.getSession().setAttribute("questions", daoq.getQuestions());
            request.getRequestDispatcher("takequiz.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        HashMap<Integer, Question> questions = (HashMap<Integer, Question>) session.getAttribute("questions");
        if (session.getAttribute("test") == null) {
            int numQuiz = Integer.parseInt(request.getParameter("numQuiz"));
            Test test = new Test(numQuiz, questions);
            session.setAttribute("test", test);
            int qesIndex = 0;
            Question question = test.getQuestions()[qesIndex];
            request.setAttribute("qesIndex", qesIndex);
            request.setAttribute("question", question);
            request.getRequestDispatcher("question.jsp").forward(request, response);
        } else {
            Test test = (Test) session.getAttribute("test");
            double score = test.getScore();
            request.setAttribute("score", score);
            request.setAttribute("percentCorrect", Math.round(score * 10));
            request.setAttribute("isPass", score > 5 ? "Pass" : "Not Pass");
            session.removeAttribute("test");
            request.getRequestDispatcher("score.jsp").forward(request, response);
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
