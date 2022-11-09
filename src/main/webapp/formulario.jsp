<%@page import="com.emergentes.parcial2.modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
  Producto p = (Producto) request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nuevo</title>
    <link rel="stylesheet" href="./css/styleForm.css">
  </head>
  <body>

    <h1>
      <%= p != null ? "Editar Producto" : "Nuevo Producto"%>
    </h1>

    <form action="MainController" method="POST">
      <input type="hidden" name="hideid" value="<%= p == null ? "0" : p.getId()%>">
      <label for="txtDescripcion">Descripcion: </label>
      <input id="txtDescripcion" 
             type="text" 
             required 
             value="<%= p == null ? "" : p.getDescripcion()%>"
             name="descripcion">

      <label for="txtCantidad">Cantidad: </label>
      <input id="txtCantidad" 
             type="number" 
             min="0" 
             max="99999" 
             required 
             value="<%= p == null ? "" : p.getCantidad()%>"
             name="cantidad">
      <label for="txtPrecio">Precio: </label>
      <input id="txtPrecio" 
             type="number" 
             min="0" 
             max="99999" 
             required 
             value="<%= p == null ? "" : p.getPrecio()%>"
             name="precio">

      <label for="txtCat">Categoria: </label>
      <select id="txtCat" 
              value="<%= p == null ? "" : p.getCategoria()%>"
              name="categoria" 
              required>
        <option>Bebidas</option>
        <option>Galletas</option>
      </select>

      <input type="submit" value="Guardar">
    </form>
  </body>
</html>
