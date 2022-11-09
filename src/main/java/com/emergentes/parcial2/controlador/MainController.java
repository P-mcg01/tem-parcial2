package com.emergentes.parcial2.controlador;

import com.emergentes.parcial2.modelo.Producto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    HttpSession sesion = request.getSession();
    
    if(sesion.getAttribute("productos") == null) {
      ArrayList<Producto> productos = new ArrayList<>();
      sesion.setAttribute("productos", productos);      
    }
    ArrayList<Producto> productos = (ArrayList<Producto>) sesion.getAttribute("productos");
    String operacion = request.getParameter("op");
    String opcion = (operacion != null) ? operacion : "index";
    
    switch(opcion) {
      case "editar":
        if(productos == null) {
          response.sendRedirect("index.jsp");
        }
        
        final int id = Integer.parseInt(request.getParameter("id"));
        Producto product = productos.stream()
          .filter(p -> p.getId() == id)
          .findAny()
          .get();
        
        request.setAttribute("product", product);
        
        request.getRequestDispatcher("formulario.jsp").forward(request, response);
        break;
      case "eliminar":
        if(productos == null) {
          response.sendRedirect("index.jsp");
        }
        
        final int idEliminar = Integer.parseInt(request.getParameter("id"));
        Producto eliminar = productos.stream()
          .filter(p -> p.getId() == idEliminar)
          .findAny()
          .get();
        productos.remove(eliminar);
        response.sendRedirect("index.jsp");
        break;
      case "index": 
        response.sendRedirect("index.jsp");
        break;
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    HttpSession sesion = request.getSession();
    ArrayList<Producto> productos = (ArrayList<Producto>) sesion.getAttribute("productos");
    
    final int id = Integer.parseInt(request.getParameter("hideid"));
    
    if(id == 0) {
      Producto producto = new Producto();
    
      producto.setPrecio(Integer.parseInt(request.getParameter("precio")));
      producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
      producto.setDescripcion(request.getParameter("descripcion"));
      producto.setCategoria(request.getParameter("categoria"));
    
      // Nuevo
      productos.add(producto);
    } else {
      Producto product = productos.stream()
          .filter(p -> p.getId() == id)
          .findAny()
          .get();
      
      // Editar
      product.setPrecio(Integer.parseInt(request.getParameter("precio")));
      product.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
      product.setDescripcion(request.getParameter("descripcion"));
      product.setCategoria(request.getParameter("categoria"));
    }
    
    response.sendRedirect("index.jsp");
  }
}
