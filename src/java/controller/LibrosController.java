/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.LibrosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LibrosModel;

/**
 *
 * @author jacqu
 */

@WebServlet(name = "LibrosController", urlPatterns = {"/LibrosController"})
public class LibrosController extends HttpServlet {
    LibrosDAO eDAO = new LibrosDAO();
    LibrosModel eModel = new LibrosModel();
    
    protected void listarLibros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
           request.setAttribute("lista", eDAO.BuscarTodos());
           request.getRequestDispatcher("listar.jsp").forward(request, response);
           
        }catch(ClassNotFoundException ex){
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String accion = request.getParameter("accion")== null ? "":request.getParameter("accion");
            int id = request.getParameter("id")== null ? 0:Integer.parseInt(request.getParameter("id"));
            String titulo = request.getParameter("titulo")== null ? "":request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion")== null ? "":request.getParameter("descripcion");
            int precio = request.getParameter("precio")== null ? 0:Integer.parseInt(request.getParameter("precio"));
            switch(accion){
                case "":
                    listarLibros(request, response);
                    break;
                case "Nuevo":
                    response.sendRedirect("nuevo.jsp");
                    break;
                case "Guardar":
                    eModel.setId(id);
                    eModel.setTitulo(titulo);
                    eModel.setDescripcion(descripcion);
                    eModel.setPrecio(precio);
                    eDAO.Insertar(eModel);
                    listarLibros(request, response);
                    break;
                case "Eliminar":
                    eDAO.Eliminar(id);
                    listarLibros(request, response);
                    break;
                case "Editar":
                    LibrosModel libros;
                try {
                    libros = eDAO.BuscarPorId(id);
                     request.setAttribute("libros", libros);
                       request.getRequestDispatcher("editar.jsp").forward(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                case "Actualizar":   
                    LibrosModel est = new LibrosModel();
                    est.setId(id);
                    est.setTitulo(titulo);
                    est.setDescripcion(descripcion);
                    est.setPrecio(precio);
                    try {
                        eDAO.Actualizar(est);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    listarLibros(request, response);
                break;
                default:
                    throw new AssertionError();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LibrosModel eModel = new LibrosModel();
        LibrosDAO eDAO = new LibrosDAO();
        eModel.setTitulo(request.getParameter("titulo"));
        eModel.setDescripcion(request.getParameter("descripcion"));
        eModel.setPrecio(Integer.parseInt(request.getParameter("precio")));
        String accion = request.getParameter("accion") == null ? "" : request.getParameter("accion");
        try {
            switch (accion) {
                case "Guardar":
                    eDAO.Insertar(eModel);
                    break;
                case "Actualizar":
                    eModel.setId(Integer.parseInt(request.getParameter("id")));
                    eDAO.Actualizar(eModel);
                    break;
                default:
                    throw new AssertionError();
            }            
            listarLibros(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
