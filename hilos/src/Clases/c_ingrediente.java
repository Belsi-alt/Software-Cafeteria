/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


public class c_ingrediente {
    private int id_ingrediente;
    private String nombre_ingre;
    private String descripcion;
    private String valor_nutri;

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getNombre_ingre() {
        return nombre_ingre;
    }

    public void setNombre_ingre(String nombre_ingre) {
        this.nombre_ingre = nombre_ingre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor_nutri() {
        return valor_nutri;
    }

    public void setValor_nutri(String valor_nutri) {
        this.valor_nutri = valor_nutri;
    }

    public c_ingrediente(int id_ingrediente, String nombre_ingre, String descripcion, String valor_nutri) {
        this.id_ingrediente = id_ingrediente;
        this.nombre_ingre = nombre_ingre;
        this.descripcion = descripcion;
        this.valor_nutri = valor_nutri;
    }

  
}
