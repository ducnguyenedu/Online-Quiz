<%-- 
    Document   : makequiz
    Created on : May 10, 2021, 5:06:47 PM
    Author     : duchi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>   
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


        <script src="root/js/createQuiz.js"></script>
        <link rel="stylesheet" href="root/css/index.css">
        <link rel="stylesheet" href="root/css/common.css">
        <link rel="stylesheet" href="root/css/makeQuiz.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Make Quiz</title>
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

                

                <form id="makeQuiz">
                    <table>
                        
                            <tr>
                                <td>Question: </td>
                                <td><textarea id="content" name="content" form="makeQuiz"></textarea></td>
                                
                            </tr>
                            <tr>
                                <td>Option 1</td>
                                <td><textarea id="otp"name="optContent" form="makeQuiz"></textarea></td>
                            </tr>
                            <tr>
                                <td>Option 2</td>
                                <td><textarea id="otp" name="optContent" form="makeQuiz"></textarea></td>
                            </tr>
                            <tr>
                                <td>Option 3</td>
                                <td><textarea id="otp" name="optContent" form="makeQuiz"></textarea></td>
                            </tr>
                            <tr>
                                <td>Option 4</td>
                                <td><textarea id="otp" name="optContent"form="makeQuiz"></textarea></td>
                            </tr>
                            <tr>
                                <td>Answer(s)</td>
                                <td>
                                    <input type="checkbox" name="isCorrect" value="0"> Option 1
                                    <input type="checkbox" name="isCorrect" value="1"> Option 2
                                    <input type="checkbox" name="isCorrect" value="2"> Option 3
                                    <input type="checkbox" name="isCorrect" value="3"> Option 4
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><button onclick="makeQuiz()" value="Save">Save</button></td>
                            </tr>
                        
                    </table>
                </form>


            </div>
        </div>
    </body>
</html>
