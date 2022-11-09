<%@page import="com.emergentes.parcial2.modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
  if(session.getAttribute("productos") == null) {
      ArrayList<Producto> lista = new ArrayList<>();
      session.setAttribute("productos", lista);      
  }
  ArrayList<Producto> productos = (ArrayList<Producto>) 
          session.getAttribute("productos");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Parcial 2</title>
    <link rel="stylesheet" href="./css/indexStyle.css">
  </head>
  <body>
    <header>
      <h1>SEGUNDO PARCIAL TEM-742</h1>
      <p><span>Nombre:</span> Pablo Manuel Condori Guachalla</p>
      <p><span>Carnet:</span> 14912156</p>        
    </header>
    <main>
      <h2>Productos</h2>
      <a class="button" href="formulario.jsp">Nuevo Producto</a>
      
      <table border="1">
        <tr>
          <th>ID</th>
          <th>Descripción</th>
          <th>Cantidad</th>
          <th>Precio</th>
          <th>Categoria</th>
          <th></th>
          <th></th>
        </tr>
        
        <% if(productos.isEmpty()) { %>
          <tr>
            <td colspan="7">LISTA VACIA</td>
          </tr>          
        <% } %>
        
        <c:forEach var="producto" items="${sessionScope.productos}">
          <tr>
            <td>${producto.getId()}</td>
            <td>${producto.getDescripcion()}</td>
            <td>${producto.getCantidad()}</td>
            <td>${producto.getPrecio()}</td>
            <td>${producto.getCategoria()}</td>
            <td>
              <a class="edit" href="MainController?op=editar&id=${producto.getId()}">
                Editar
              </a>
            </td>
            <td>
              <a class="delete" href="MainController?op=eliminar&id=${producto.getId()}">
                Eliminar
              </a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </main>
  </body>
</html>
