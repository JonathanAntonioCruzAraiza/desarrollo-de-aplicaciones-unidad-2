/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.edu.mx.modelo;

/**
 *
 * @author jony
 */
public class TipoHabitacion {
    private int id_tipoHabitacion;
    private String nombre;
    private String descripcion;
    private  int capacidad;
    private int precio;
    private String hotel;

    public TipoHabitacion(int id_tipoHabitacion, String nombre, String descripcion, int capasidad, int precio, String hotel) {
        this.id_tipoHabitacion = id_tipoHabitacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidad = capasidad;
        this.precio = precio;
        this.hotel = hotel;
    }

    public TipoHabitacion(){
        this(0,"","",0,0,"");
    }
    
    
    public int getId_tipoHabitacion() {
        return id_tipoHabitacion;
    }

    public void setId_tipoHabitacion(int id_tipoHabitacion) {
        this.id_tipoHabitacion = id_tipoHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capasidad) {
        this.capacidad = capasidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "TipoHabitacion{" + "id_tipoHabitacion=" + id_tipoHabitacion + ", nombre=" + nombre + ", descripcion=" + descripcion + ", capacidad=" + capacidad + ", precio=" + precio + ", hotel=" + hotel + '}';
    }


    

   }
