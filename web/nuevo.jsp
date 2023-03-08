<%-- 
    Document   : Nuevo
    Author     : jacqu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Libro</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body class="mx-auto" style="width: 450px;">  
        <h2 class="text-center">♥----------------------♥</h2>
        <h2 class="text-center">Nuevo Libro</h2>
        <h2 class="text-center">♥----------------------♥</h2>
        <form action="LibrosController" method="POST">
        <div class="text-center">
            <div class="mb-3">
                <input type="hidden" name="id" id="id">
                <label class="form-label">Titulo</label>
                <input type="text" class="form-control" name="titulo" id="titulo">
                <div class="form-text">Ingrese el nombre del libro.</div>
            </div>
            <div class="mb-3">
                <label class="form-label">Descripcion</label>
                <input type="text" class="form-control" name="descripcion" id="descripcion">
                <div class="form-text">Ingrese la descripcion del libro.</div>
            </div>
            <div class="mb-3">
                <label class="form-label">Precio</label>
                <input type="number" class="form-control" name="precio" id="precio">
                <div class="form-text">Ingrese el precio del libro.</div>
            </div>
            <br>
        </div>
        <br>
        <div class="text-center"> 
            <input class="btn btn-info" type="submit" name="accion" value="Guardar">
        </div>
        </form>
    </body>
</html>
