/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Clases;

import java.util.Date;
public class Cliente {

   private long cedula_cliente;
   private String nombre_apellido;
   private long telefono;
   private String correo;
   private String direccion;
   private Date fecha_nacimiento;

    public long getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(long cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Cliente(long cedula_cliente, String nombre_apellido, long telefono, String correo, String direccion, Date fecha_nacimiento) {
        this.cedula_cliente = cedula_cliente;
        this.nombre_apellido = nombre_apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
