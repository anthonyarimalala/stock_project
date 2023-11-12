<!DOCTYPE html>

<html>
    <head>
        <title>Consultation</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            
            <h2>Mouvements: </h2>
        <div class="container mt-5">
            <h2>Sélectionner une plage de dates</h2>

            <div class="col-md-6">
                <div class="form-group">
                    <label for="startDate">Date de debut :</label>
                    <input type="date" class="form-control" id="startDate" name="startDate">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="endDate">Date de fin :</label>
                    <input type="date" class="form-control" id="startDate" name="finDate">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Soummettre</button>
        </div>
        

            <br/>
            <br/>
        <h2>Mouvements: </h2>
        <table class="table">
            <thead>
              <tr>
                <th scope="col">Magasin</th>
                <th scope="col">Date</th>
                <th scope="col">Article</th>
                <th scope="col">Prix Unitaire</th>
                <th scope="col">Quantite / Prix</th>
                <th scope="col">Stock / Prix</th>
                <th scope="col">Unite</th>
                <th scope="col">Type</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>@mdo</td>
              </tr>
              <tr class="table-success">
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>@mdo</td>
              </tr>
              <tr class="table-danger">
                <th scope="row">3</th>
                <td colspan="2">Larry the Bird</td>
                <td>@twitter</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>@mdo</td>
              </tr>
            </tbody>
        </table>
    </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
