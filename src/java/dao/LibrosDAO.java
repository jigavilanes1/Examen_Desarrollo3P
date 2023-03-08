/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.LibrosModel;
/**
 *
 * @author jacqu
 */
public class LibrosDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion conexion = new Conexion();
    Connection conn;
    boolean respuesta = false;
    
    public ArrayList<LibrosModel> BuscarTodos() throws ClassNotFoundException{
        ArrayList<LibrosModel>lista = new ArrayList<LibrosModel>();
        String sql = "select * from libros";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                LibrosModel librosTemp = new LibrosModel();
                librosTemp.setId(Integer.parseInt(rs.getString("Id")));
                librosTemp.setTitulo(rs.getString("Titulo"));
                librosTemp.setDescripcion(rs.getString("Descripcion"));
                librosTemp.setPrecio(Integer.parseInt(rs.getString("Precio")));
                lista.add(librosTemp);
            }
        }catch(SQLException ex){
            System.out.println("Error al Buscar Todos()"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return lista;
    }
    
    public LibrosModel BuscarPorId(int id) throws ClassNotFoundException{
        LibrosModel librosTemp = new LibrosModel();
        String sql = "select * from libros where id =?";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                librosTemp.setId(rs.getInt("Id"));
                librosTemp.setTitulo(rs.getString("Titulo"));
                librosTemp.setDescripcion(rs.getString("Descripcion"));
                librosTemp.setPrecio(rs.getInt("Precio"));
            }
        }catch(SQLException ex){
           System.out.println("Error al Buscar por ID()"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return librosTemp;
    }
    
    public boolean Insertar(LibrosModel eModel) throws ClassNotFoundException{
        String sql = "insert into libros(titulo,descripcion,precio) values(?,?,?)";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setString(1, eModel.getTitulo());
            ps.setString(2, eModel.getDescripcion());
            ps.setInt(3, eModel.getPrecio());
            if(ps.executeUpdate()>0){
                respuesta = true;
            }
        }catch(SQLException ex){
           System.out.println("Error al Insertar"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return respuesta;
    }
    
    public boolean Actualizar(LibrosModel eModel) throws ClassNotFoundException{
        String sql = "update libros set titulo =?, descripcion =?, precio=? where id =?";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setString(1, eModel.getTitulo());
            ps.setString(2, eModel.getDescripcion());
            ps.setInt(3, eModel.getPrecio());
            ps.setInt(4,eModel.getId());
            if(ps.executeUpdate()>0){
                respuesta = true;
            }
        }catch(SQLException ex){
           System.out.println("Error al Actualizar"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return respuesta;
    }
    
    public boolean Eliminar(int id) throws ClassNotFoundException{
        String sql = "delete from libros where id =?";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                respuesta = true;
            }
        }catch(SQLException ex){
           System.out.println("Error al Eliminar"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return respuesta;
    }
}
