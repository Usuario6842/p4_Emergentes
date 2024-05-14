/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_blog.dao;

import com.mycompany.crud_blog.modelo.Blog;
import com.mycompany.crud_blog.utiles.ConexionDB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class BlogDAOImp extends ConexionDB implements BlogDAO {
 
    
    @Override
    public void insert(Blog blog) {
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO Blog VALUES(?,?,?,?);");
            ps.setInt(1, blog.getId());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.setDate(4, Date.valueOf(blog.getFecha()));
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BlogDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Desconectar();
        }
    }

    @Override
    public void update(Blog blog) {
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE Blog SET titulo=?, contenido=?, fecha=? WHERE id=?");

            ps.setString(1, blog.getTitulo());
            ps.setString(2, blog.getContenido());
            ps.setDate(3, Date.valueOf(blog.getFecha()));
            ps.setInt(4, blog.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BlogDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Desconectar();
        }
    }

    @Override
    public void delete(int id) {
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM Blog WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BlogDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Desconectar();
        }
    }

    @Override
    public List<Blog> getAll() {
        List blogs = null;
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM Blog;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Blog b1 = new Blog();

                b1.setId(rs.getInt("id"));
                b1.setTitulo(rs.getString("titulo"));
                b1.setContenido(rs.getString("contenido"));
                b1.setFecha(rs.getDate("fecha").toLocalDate());

                blogs.add(b1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BlogDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Desconectar();
        }
        return blogs;
    }

    @Override
    public Blog getById(int id) {
        Blog b1 = new Blog();
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM Blog WHERE id=?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                b1.setId(rs.getInt("id"));
                b1.setTitulo(rs.getString("titulo"));
                b1.setContenido(rs.getString("contenido"));
                b1.setFecha(rs.getDate("fecha").toLocalDate());

            }

        } catch (SQLException ex) {
            Logger.getLogger(BlogDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Desconectar();
        }
        return b1;
    }

}
