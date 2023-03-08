<%-- 
    Document   : Nuevo
    Author     : jacqu
--%>

<%@page import="model.LibrosModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Libros</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body class="mx-auto" style="width: 450px;">  
        <h2 class="text-center">♥----------------------♥</h2>
        <h2 class="text-center">Editar Libros</h2>
        <h2 class="text-center">♥----------------------♥</h2>
        <%
            LibrosModel libros = (LibrosModel) request.getAttribute("libros");
            
          %>
        <form action="LibrosController" method="GET">
          
        <div class="text-center">
            <input type="hidden" name="id" value="<%=libros.getId()%>"> 
            <div class="mb-3">
                <label class="form-label">Titulo</label>
                <input type="text" class="form-control" name="titulo" id="titulo" value="<%=libros.getTitulo()%>">
                <div class="form-text">Actualice el titulo del libro.</div>
            </div>
            <div class="mb-3">
                <label class="form-label">Descripcion</label>
                <input type="text" class="form-control" name="descripcion" id="descripcion" value="<%=libros.getDescripcion()%>">
                <div class="form-text">Actualice la descripcion del libro.</div>
            </div>
            <div class="mb-3">
                <label class="form-label">Precio</label>
                <input type="number" class="form-control" name="precio" id="precio" value="<%=libros.getPrecio()%>">
                <div class="form-text">Actualice el precio del libro.</div>
            </div>
            <br>
        </div>
        <br>
        <div class="text-center"> 
            <input class="btn btn-info" type="submit" name="accion" value="Actualizar">
        </div>
        </form>
    </body>
</html>
