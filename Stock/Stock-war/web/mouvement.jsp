<%@page import="magasin.Stock"%>
<%@page import="java.util.List"%>
<%
    List<Stock> stocks = (List<Stock>)request.getAttribute("stocks");
    %>

<!DOCTYPE html>

<html>
    <head>
        <title>Mouvements</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="header.jsp" %>
        
        <div class="container">
        <h2>Mouvements: </h2>
        <form class="row g-3" action="MouvementToMouvement">
          
          
          <div class="col-md-6">
            <label for="inputCity" class="form-label">Date: </label>
            <input type="datetime-local" class="form-control" id="inputCity" name="date_mouvement">
          </div>
          <div class="col-6">
            <label for="article" class="form-label">Article: </label>
            <select class="form-select" name="id_stock">
                <% for (Stock stock : stocks) { %>
                    <option value="<%= stock.getIdStock() %>"><%= stock.getEmplacement() %> - <%= stock.getArticle() %></option>
                <% } %>
            </select>
          </div>
          <div class="col-md-2">
            <label for="mouvement" class="form-label">Mouvement: </label>
            <input type="number" min="1" class="form-control" id="mouvement" name="mouvement" value="1">
          </div>
            <div class="col-md-1">
          </div>
          <div class="col-1">
            <label for="article" class="form-label">Type: </label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="type" value="in" id="flexRadioDefault1" />
                <label class="form-check-label" for="flexRadioDefault1">
                  In
                </label>
              </div>
          </div>
          <div class="col-1">
              <label for="article" class="form-label" style="color: #ffffff"> .</label>
            
              <div class="form-check">
                <input class="form-check-input" type="radio" name="type" value="out" id="flexRadioDefault2" checked />
                <label class="form-check-label" for="flexRadioDefault2">
                  Out
                </label>
              </div>
          </div>
          <div class="col-12">
            <button type="submit" class="btn btn-primary">Valider</button>
          </div>
        </form>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
