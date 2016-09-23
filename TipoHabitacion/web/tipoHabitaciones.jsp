<%-- 
    Document   : tipoHabitaciones
    Created on : 22-sep-2016, 14:53:45
    Author     : jony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="TipoHabitacionController" method="post">
            <fieldset>
                
                <div>
                    <label>Id tipoHabitacion:</label>
                    <input type="text" name="id_tipoHabitacion" value="${tipoHabitacion.id_tipoHabitacion}"
                           placeholder="id_tipoHabitacion"
                           readonly="readonly"/>

                </div>
                <div>
                    <label>Nombre:</label>
                    <input type="text" name="nombre" value="${tipoHabitacion.nombre}"
                           placeholder="nombre"/>
                </div>
                <div>
                    <label>Descripcion:</label>
                    <input type="text" name="descripcion" value="${tipoHabitacion.descripcion}"
                           placeholder="descripcion"/>
                </div>
                <div>

                    <label>Capacidad:</label>
                    <input type="text" name="capacidad" value="${tipoHabitacion.capacidad}"
                           placeholder="capacidad"/>
                </div>
                <div>
                    <label>Precio:</label>
                    <input type="number" name="precio" value="${tipoHabitacion.precio}"
                           placeholder="precio"/>
                </div>
                           
                            <div>
                    <label>Hotel:</label>
                    <input type="text" name="hotel" value="${tipoHabitacion.hotel}"
                           placeholder="hotel"/>
                </div>
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fieldset>

        </form>




    </body>
</html>
