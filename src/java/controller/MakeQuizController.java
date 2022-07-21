/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DAOQuestion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Answer;
import model.Question;
import model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author duchi
 */
public class MakeQuizController extends HttpServlet {

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
        request.getRequestDispatcher("makequiz.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();

        Map<String, String[]> parameterMap = request.getParameterMap();
        Question question = new Question();
        question.setQuest(parameterMap.get("content")[0]);
        ArrayList<Answer> answers = new ArrayList<>();
        for (String optContent : parameterMap.get("optContent")) {
            Answer answer = new Answer();
            answer.setQuestion(question);
            answer.setContent(optContent);
            answer.setIsTrue(false);
            answers.add(answer);

        }
        for (String isCorrect : parameterMap.get("isCorrect")) {
            answers.get(Integer.parseInt(isCorrect)).setIsTrue(true);
        }
        User user = (User) request.getSession().getAttribute("user");
        question.setAnswers(answers);
        DAOQuestion daoq = new DAOQuestion();
        JSONArray list = new JSONArray();
        JSONObject obj = new JSONObject();
        String msg;
        if (daoq.createQuestion(question,user)) {

            msg = "1";
            obj.put("msg", msg);
            list.add(obj);
            out.println(list.toJSONString());

            out.flush();
            System.out.println("done");
        } else {

            msg = "2";
            obj.put("msg", msg);
            list.add(obj);
            out.println(list.toJSONString());

            out.flush();
            System.out.println("faile");
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
