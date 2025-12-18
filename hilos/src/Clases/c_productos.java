/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


public class c_productos {
    
private int id_producto;
private String nom_producto;
private int id_familia;
private String descripcion;
private double precio;
private Integer[] id_ingrediente;

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public int getId_familia() {
        return id_familia;
    }

    public void setId_familia(int id_familia) {
        this.id_familia = id_familia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer[] getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(Integer[] id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public c_productos(int id_producto, String nom_producto, int id_familia, String descripcion, double precio, Integer[] id_ingrediente) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.id_familia = id_familia;
        this.descripcion = descripcion;
        this.precio = precio;
        this.id_ingrediente = id_ingrediente;
    }

}