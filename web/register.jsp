<%-- 
    Document   : register
    Created on : May 10, 2021, 4:33:06 PM
    Author     : duchi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>   
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


        <script src="root/js/register.js"></script>
        <link rel="stylesheet" href="root/css/index.css">
        <link rel="stylesheet" href="root/css/common.css">
        <link rel="stylesheet" href="root/css/loginForm.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Register</title>
    </head>
    <body>
        <div id="main-panel">
            <div id="nav-bar">
                <ul>
                    <li><a href='HomePage'>Home</a></li>
                    <li><a href='TakeQuiz'>Take Quiz</a></li>
                    <li><a href='MakeQuiz'>Make Quiz</a></li>
                    <li><a href='ManageQuiz'>Manage Quiz</a></li>

                </ul>
            </div>
            <div id="main-content">
                <body>
                    <h1 id="fornTitle">Registration Form</h1></br>

                    <form name="frm-register" id="frm-register">
                        <table>
                            <tr>
                                <td>User Name: </td>
                                <td><input type="text" id="username" name="username" required></td>
                            </tr>
                            <tr>
                                <td>Password: </td>
                                <td><input type="password" id="password" name="password" required></td>
                            </tr>
                            <tr>
                                <td>User Type</td>
                                <td>
                                    <select id="type" name="type" value="0">
                                        <option value='0'>Student</option>
                                        <option value='1'>Teacher</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Email: </td>
                                <td><input type="email" id="email" name="email"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <button type="button" onclick="register()">Register</button> 

                                </td>
                            </tr>

                        </table>
                    </form>


            </div>
        </div>
    </body>
</html>
