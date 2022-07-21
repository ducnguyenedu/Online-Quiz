<%-- 
    Document   : question
    Created on : May 25, 2021, 9:45:51 AM
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


        <script src="root/js/quizPage.js"></script>
        <link rel="stylesheet" href="root/css/index.css">
        <link rel="stylesheet" href="root/css/common.css">
        <link rel="stylesheet" href="root/css/quizPage.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
            timeRemind();
        </script>
        <title>Take Quiz</title>
    </head>
    <body>
        <div id="main-panel">
            <div id="nav-bar">
                <ul>
                    <li><a>Home</a></li>
                    <li><a>Take Quiz</a></li>
                    <li><a>Make Quiz</a></li>
                    <li><a>Manage Quiz</a></li>
                    <li><a>Log out</a></li>
                </ul>
            </div>
            <div id="main-content">


                <h1 id="fornTitle">Welcome <span class="userName"></span></h1>
                <h4 id="TimeSpan">Time remaining: <span id="timeDisplay" name="timeDisplay" ></span></h4>

                <form id="quest" action="TakeQuiz" method="GET">
                    <input type="hidden" id="timeR" name="timeR" value="${sessionScope.test.time}">
                    <input type="hidden" id="qesIndex" name="qesIndex" value="${requestScope.qesIndex}">
                    <div>${requestScope.question.quest}</div>
                    <c:forEach items="${requestScope.question.answers}" var="ans">
                        <input type="checkbox" name="answer" value="${ans.id}"> ${ans.content}</br>
                    </c:forEach>



                    <button  onclick="nextQuestion()">Next</button>

                </form>






            </div>
        </div>
    </body>
</html>


