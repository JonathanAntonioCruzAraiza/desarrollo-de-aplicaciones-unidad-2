<%-- 
    Document   : listarTipoHabitaciones
    Created on : 22-sep-2016, 14:52:56
    Author     : jony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
        <title>JSP Page</title>
    </head>
    <body>

        <body>
        <table>
            <thead>
                <tr>
                    <th>Id tipoHabitacion</th>
                    <th>nombre</th>
                    <th>descripcion</th>
                    <th>cantidad</th>
                    <th>precio</th>
                    <th>hotel</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach  var="tipoHabitacion" items="${tipoHabitacions}">
                    <tr>
                        <td>${tipoHabitacion.id_tipoHabitacion}</td>
                        <td>${tipoHabitacion.nombre}</td>
                        <td>${tipoHabitacion.descripcion}</td>
                        <td>${tipoHabitacion.capacidad}</td>
                        <td>${tipoHabitacion.precio}</td>
                        <td>${tipoHabitacion.hotel}</td>
                        <td><a href="TipoHabitacionController?action=cambiar&id_tipoHabitacion=${tipoHabitacion.id_tipoHabitacion}">Cambiar</a></td> 
                        <td><a href="TipoHabitacionController?action=borrar&id_tipoHabitacion=${tipoHabitacion.id_tipoHabitacion}">Borrar</a></td> 
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="TipoHabitacionController?action=agregar">tipo Habitacion</a>
        </p>


    </body>
</html>
