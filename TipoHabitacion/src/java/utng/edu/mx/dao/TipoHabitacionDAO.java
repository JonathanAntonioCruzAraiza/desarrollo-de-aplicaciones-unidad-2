/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.edu.mx.dao;

import java.util.List;
import utng.edu.mx.modelo.TipoHabitacion;

/**
 *
 * @author jony
 */
public interface TipoHabitacionDAO {
    
        
       
    void agregarTipoHabitacion(TipoHabitacion tipoHabitacion);
    void borrarTipoHabitacion(int id_TipoHabitacion);
    void cambiarTipoHabitacion(TipoHabitacion tipoHabitacion);
    List<TipoHabitacion>desplegarTipoHabitacion();
    TipoHabitacion elegirTipoHabitacion(int id_TipoHabitacion);
    
}
