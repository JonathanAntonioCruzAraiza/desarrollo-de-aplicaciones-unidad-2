/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.edu.mx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utng.edu.mx.dao.TipoHabitacionDAO;
import utng.edu.mx.dao.TipoHabitacionDAOImp;
import utng.edu.mx.modelo.TipoHabitacion;

/**
 *
 * @author jony
 */
@WebServlet(name = "TipoHabitacionController", urlPatterns = {"/TipoHabitacionController"})
public class TipoHabitacionController extends HttpServlet {

    private static final String LISTA_TIPOHABITACIONES
            = "/listarTipoHabitaciones.jsp";
    private static final String AGREGAR_O_CAMBIAR
            = "/tipoHabitaciones.jsp";

    private TipoHabitacionDAO dao;

    public TipoHabitacionController() {
        dao = new TipoHabitacionDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_TIPOHABITACIONES;
            int id_tipoHabitacion = Integer.parseInt(request.getParameter("id_tipoHabitacion"));
            dao.borrarTipoHabitacion(id_tipoHabitacion);
            request.setAttribute("tipoHabitacions", dao.desplegarTipoHabitacion());

        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int id_tipoHabitacion = Integer.parseInt(request.getParameter("id_tipoHabitacion"));
            TipoHabitacion tipoHabitacion = dao.elegirTipoHabitacion(id_tipoHabitacion);
            request.setAttribute("tipoHabitacion", tipoHabitacion);

        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;

        } else {
            forward = LISTA_TIPOHABITACIONES;
            request.setAttribute("tipoHabitacions", dao.desplegarTipoHabitacion());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TipoHabitacion tipoHabitacion = new TipoHabitacion();

        String id_tipoHabitacion = request.getParameter("id_tipoHabitacion");
        tipoHabitacion.setNombre(request.getParameter("nombre"));
        tipoHabitacion.setDescripcion(request.getParameter("descripcion"));
        tipoHabitacion.setCapacidad(Integer.parseInt(request.getParameter("capacidad")));
        tipoHabitacion.setPrecio(Integer.parseInt(request.getParameter("precio")));
        tipoHabitacion.setHotel(request.getParameter("hotel"));
        if (id_tipoHabitacion == null || id_tipoHabitacion.isEmpty()) {
            dao.agregarTipoHabitacion(tipoHabitacion);
        } else {
            tipoHabitacion.setId_tipoHabitacion(Integer.parseInt(id_tipoHabitacion));
            dao.cambiarTipoHabitacion(tipoHabitacion);
        }

        RequestDispatcher view = request.getRequestDispatcher(LISTA_TIPOHABITACIONES);
        request.setAttribute("tipoHabitacions", dao.desplegarTipoHabitacion());
        view.forward(request, response);

    }

}
