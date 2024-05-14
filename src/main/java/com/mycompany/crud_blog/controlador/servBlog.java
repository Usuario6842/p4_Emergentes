/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.crud_blog.controlador;

import com.mycompany.crud_blog.dao.BlogDAO;
import com.mycompany.crud_blog.dao.BlogDAOImp;
import com.mycompany.crud_blog.modelo.Blog;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class servBlog extends HttpServlet {

    private BlogDAO blogDAO;

    public void init() {
        blogDAO = new BlogDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        int id = Integer.parseInt(request.getParameter("id"));
        List listaBlogs = blogDAO.getAll();
        Blog blog;

        switch (op) {
            case "create":
                blog = new Blog();
                request.setAttribute("actualBlog", blog);
                request.getRequestDispatcher("editar.jsp").forward(request, response);

                break;
            case "update":
                if (getId(id, listaBlogs) != -1) {
                    blog =(Blog) listaBlogs.get(getId(id, listaBlogs));
                    request.setAttribute("lastId", id);
                    request.setAttribute("actualBlog", blog);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                }
                break;
            case "delete":
                if(getId(id, listaBlogs) != -1){
                    blogDAO.delete(id);
                    response.sendRedirect("index.jsp");
                }
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        int id = Integer.parseInt(request.getParameter("id"));
        List listaBlogs = blogDAO.getAll();
        
        Blog blog = new Blog();
        blog.setId(id);
        blog.setTitulo(titulo);
        blog.setContenido(contenido);
        blog.setFecha(fecha);

        if(getId(id, listaBlogs) != -1){
            blogDAO.update(blog);
        }else{
            blogDAO.insert(blog);
        }
        

        
    }

    public int getId(int id, List<Blog> lista) {
        int pos = 0;
        for (Blog blog : lista) {
            if (blog.getId() == id) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

}
