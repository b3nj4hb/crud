/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.crud.config.Conexion;
import pe.edu.upeu.crud.model.Producto;

/**
 *
 * @author benja
 */
public class ProductoDao {
    PreparedStatement ps;
    ResultSet rs;
    Conexion c=new Conexion();
    Connection con;
    
    public List listar(){
    List<Producto>lista=new ArrayList<>();
    String sql="select * from producto";
    try {
        con=Conexion.getConexion();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()) {
            Producto p = new Producto();
            p.setIdproducto(rs.getInt(1));
            p.setNombre(rs.getString(2));
            p.setPrecio(rs.getDouble(3));
            p.setStock(rs.getInt(4));
            p.setIdcategoria(rs.getInt(5));
            lista.add(p);
        }
    }catch (Exception e) {
    }
    return lista;
    
    }
}
