<%-- 
    Document   : managequiz
    Created on : May 10, 2021, 5:07:24 PM
    Author     : duchi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>   
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>



        <link rel="stylesheet" href="root/css/index.css">
        <link rel="stylesheet" href="root/css/common.css">
        <link rel="stylesheet" href="root/css/manageQuiz.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Manage Quiz</title>
    </head>
    <body>
        <div id="main-panel">
           <div id="nav-bar">
                <ul>
                    <li><a href='HomePage'>Home</a></li>
                    <li><a href='TakeQuiz'>Take Quiz</a></li>
                    <li><a href='MakeQuiz'>Make Quiz</a></li>
                    <li><a href='ManageQuiz'>Manage Quiz</a></li>
                    <li><a href='Logout'>Log out</a></li>
                </ul>
            </div>
            <div id="main-content">
                </br>

                <h3 id="fornTitle">Number of question: <span class="blue">${requestScope.questions.size()}</span></h3>
                </br>
                <table>
                    <colgroup>
                        <col class="labelCol">
                        <col class="fieldCol">
                        <col class="fieldAction">
                    </colgroup>
                    <thead>
                        <tr>
                            <th>Question</th>
                            <th>Date Created</th>

                        </tr>
                    </thead>

                    <c:forEach items="${requestScope.questions}" var="que">
                        <tr>
                            <td>${que.value.quest}</td>
                            <td>${que.value.date}</td>

                        </tr>
                        <tr><td></td><td></td></tr>
                        <tr><td></td><td></td></tr>
                        <tr><td></td><td></td></tr>
                    </c:forEach>


                </table>
            </div>
    </body>
</html>
