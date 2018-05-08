<%-- 
    Document   : StadisticsPage
    Created on : 03-May-2018, 21:56:54
    Author     : 1996f
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="beans.Stadistics"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" 
              integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <title>Statistics</title>
    </head>
    <style>
        body {font-family: "Lato", sans-serif}
        .mySlides {display: none}
    </style>
    <body>
            <!-- Navbar -->
            <div class="w3-top">
            <div class="w3-bar w3-black w3-card">
                <a href="ListSong.jsp" class="w3-bar-item w3-button w3-padding-large">CATALOGUE</a>
                <a href="MyAlbum.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">MY ALBUM</a>
                <a href="FavAlbum.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">FAVOURITE ALBUM</a>
                <a href="MyCart.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">SEE MY CART</a>
                <a>
                    <form action="Servlet">
                        <input type="hidden" name="command" value="logoutCommand">
                        <input class="w3-padding-large w3-hover-red w3-hide-small w3-right" type="submit" value="Logout">
                    </form>
                </a>
                <a href="LogPage.jsp" class="w3-padding-large w3-hover-red w3-hide-small w3-right">LOG PAGE</a>
                <a href="StadisticsPage.jsp" class="w3-padding-large w3-hover-red w3-hide-small w3-right">STATISTICS</a>
            </div>
        </div>
    
        <%
            Stadistics stadistics = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/Stadistics");
            int Album = stadistics.getAlbum();
            int Bill = stadistics.getBill();
            int Cart = stadistics.getCart();
            int CreditCard = stadistics.getCreditCard();
            int Song = stadistics.getSong();
            int SongList = stadistics.getSongList();

            int BillPage = stadistics.getBillPage();
            int FavAlbum = stadistics.getFavAlbum();
            int ListSong = stadistics.getListSong();
            int MyAlbum = stadistics.getMyAlbum();
            int MyCart = stadistics.getMyCart();
            int Payment = stadistics.getPayment();
            int Seguro = stadistics.getSeguro();
            int index = stadistics.getIndex();
        %>
        <br><br>
        <h1> Statistics of the page : </h1>
        <p>Album bean visits :<%= Album %></p>
        <p>Bill bean visits : <%= Bill %></p>
        <p>Cart bean visits : <%= Cart %></p>
        <p>CreditCard bean visits : <%= CreditCard %></p>
        <p>Song bean visits : <%= Song %></p>
        <p>SongList bean visits : <%= SongList %></p>
        <p>Bill page visits : <%= BillPage %></p>
        <p>Favourite album page visits : <%= FavAlbum %></p>
        <p>Catalog page visits : <%= ListSong %></p>
        <p>My album page visits : <%= MyAlbum %></p>
        <p>My cart page visits : <%= MyCart %></p>
        <p>Payment page visits : <%= Payment %></p>
        <p> Sure page visits : <%= Seguro %></p>
        <p> Index page visits : <%= index %></p>
        
        <footer class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">
                    <i class="fa fa-facebook-official w3-hover-opacity"></i>
                    <i class="fa fa-instagram w3-hover-opacity"></i>
                    <i class="fa fa-snapchat w3-hover-opacity"></i>
                    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
                    <i class="fa fa-twitter w3-hover-opacity"></i>
                    <i class="fa fa-linkedin w3-hover-opacity"></i>
                </footer>
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </body>
</html>
