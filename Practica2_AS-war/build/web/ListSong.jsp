<%-- 
    Document   : listSong
    Created on : 26-Feb-2018, 17:36:45
    Author     : 1996f
--%>

<%@page import="beans.Stadistics"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="beans.LogBean"%>
<%@page import="beans.Song"%>
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

        <title>Catalogue</title>
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
        <br><br>
        <h1 class="w3-jumbo w3-center w3-animate-top">Catalogue</h1>
        
        <div class="w3-content" style="max-width:2000px;margin-top:46px">
            <div class="w3-container w3-content w3-center w3-padding-64" style="max-width:800px" id="band">
                <table class="table table-striped table-dark">
                    <thead>
                        <tr> 
                            <th scope="col">Tittle</th> 
                            <th scope="col">Artist</th> 
                            <th scope="col">Price</th> 
                            <th scope="col">Buy</th> 
                        </tr> 
                    </thead> 
                    <tbody>
                        <%  Stadistics stadistics = (Stadistics) InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/Stadistics");
                            stadistics.addListSong();
                            LogBean log = (LogBean) InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
                            log.writeLog("ListSong", "doGet");
                            SongList catalog = (SongList) InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/SongList");
                            Song cancion = (Song) InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/Song");
                            for (int idx = 0; idx < catalog.size(); idx++) {
                                cancion = catalog.get(idx);
                        %>
                    <form action="Servlet">

                        <tr><td><%= cancion.getTittle()%></td><td><%= cancion.getArtist()%></td><td> <%= cancion.getPrice()%> € </td><td>
                                <input type="hidden" name="id" value=<%= cancion.getId()%>>
                                <input type="hidden" name="command" value="addCartCommand">
                                <input type="submit" value="Buy"></td>
                        </tr>
                    </form>

                    <% }%>
                    </tbody>


                </table>
                <% session = request.getSession();
                    if (session.getAttribute("error") != null && session.getAttribute("error").equals("repeat1")) {
                %>
                <h3 style="color: red">This song is already in your cart</h3>
                <%session.setAttribute("error", "OK");
                    }
                %>
                <%if (session.getAttribute("error") != null && session.getAttribute("error").equals("repeat")) {
                %>
                <h3 style="color: red">This song is already in your album</h3>
                <%session.setAttribute("error", "OK");
                    }

                %>
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
