<%-- 
    Document   : index
    Created on : 25-Feb-2018, 18:59:34
    Author     : 1996f
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="beans.Stadistics"%>
<%@page import="beans.Album"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    </head>
    <style>
        body,h1 {font-family: "Raleway", sans-serif}
        body, html {height: 100%}
        .bgimg {
            background-image: url('https://www.taylorintime.com/wp-content/uploads/2016/11/Music.jpg');
            min-height: 100%;
            background-position: center;
            background-size: cover;
        }
    </style>
    <body>
        <%
            Stadistics stadistics = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/Stadistics!beans.Stadistics");
            stadistics.addIndex();
        %>
        <div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
            <header class="w3-container w3-center" style="padding:128px 16px">
                <h1 class="w3-container w3-center" style="color: whitesmoke">Your Album</h1>
                <form action="Servlet">
                    <div class="form-group">
                        <label for="name1">Name</label><br>
                        <input type="text" class="form-control" id="name1" aria-describedby="nameHelp" placeholder="Enter bame" name="name">
                    </div>
                    <div class="form-group">
                        <label for="password1">Password</label><br>
                        <input type="password" class="form-control" id="password1" placeholder="Password" name="password">
                    </div>
                    <input type="hidden" name="command" value="loginCommand">
                    <input type="submit" class="btn btn-primary" value="Sing in">
                </form>
            </header>
 
            <p>You have to login to show the list</p>
    

            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        </div>
    </body>
</html>
