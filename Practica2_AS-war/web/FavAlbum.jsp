<%-- 
    Document   : FavAlbum
    Created on : 25-Feb-2018, 17:06:55
    Author     : 1996f
--%>

<%@page import="beans.Stadistics"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="beans.LogBean"%>
<%@page import="beans.SongList"%>
<%@page import="beans.Album"%>
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

        <title>Favourite Album</title>
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
        <div class="w3-content" style="max-width:2000px;margin-top:46px">

            <%
                Stadistics stadistics = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/Stadistics");
                stadistics.addFavAlbum();
                LogBean log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
                log.writeLog("FavAlbum", "doGet");
                session = request.getSession();
                Album favAlbum = (Album) session.getAttribute("Favourite");
                if (favAlbum != null) {%>
            <div class="w3-container w3-content w3-center w3-padding-64" style="max-width:800px" id="band">
                <h1 class="w3-wide">This is your favourite album</h1>
                <table class="table table-striped table-dark">
                    <thead>
                        <tr> 
                            <th scope="col">Tittle</th> 
                            <th scope="col">Artist</th> 
                        </tr> 
                    </thead> 
                    <tbody>
                        <% for (int idx = 0; idx < favAlbum.size(); idx++) { %>
                        <% String tittle = favAlbum.getSong(idx).getTittle(); %>
                        <% String artist = favAlbum.getSong(idx).getArtist();
                            int id = favAlbum.getSong(idx).getId();
                        %>
                    <form action="Servlet">
                        <tr><td><%= tittle%></td><td><%= artist%></td><td>
                                <input type="hidden" name="id" value=<%= id%>>
                                <input type="hidden" name="task" value="fav">
                                <input type="hidden" name="command" value="SeguroCommand">
                                <input type="submit" value="Delete"></td>
                    </form>
                    <%}%>
                    </tbody>
                </table>
                <%  }%>
            </div>
        </div>
        <!-- Footer -->
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
