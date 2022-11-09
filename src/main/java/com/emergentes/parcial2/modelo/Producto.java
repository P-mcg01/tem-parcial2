package com.emergentes.parcial2.modelo;

public class Producto {
  private int id;
  private int cantidad;
  private int precio;
  private String descripcion;
  private String categoria;
  
  private static int productoId = 0;

  public Producto() {
    productoId++;
    this.setId(productoId);
  }

  public int getId() {
    return id;
  }

  private void setId(int id) {
    this.id = id;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public int getPrecio() {
    return precio;
  }

  public void setPrecio(int precio) {
    this.precio = precio;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
}
