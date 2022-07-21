<%-- 
    Document   : score
    Created on : May 25, 2021, 9:03:24 PM
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
        <link rel="stylesheet" href="root/css/quizPage.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Take Quiz</title>
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


                <h1 id="fornTitle">Your score <span class="userName">${requestScope.score} (${requestScope.percentCorrect} %) - ${requestScope.isPass} </span></h1>


                <form action="TakeQuiz" method="post">


                    <div><input type="hidden" value="${sessionScope.questions.size()}" id="numQuiz" name="numQuiz"></div>

                   <div>  Take another test <input type="submit" value="Start"></div>

                </form>






            </div>
        </div>
    </body>
</html>
