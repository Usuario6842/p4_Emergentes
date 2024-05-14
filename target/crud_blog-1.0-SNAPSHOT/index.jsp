<%-- 
    Document   : index
    Created on : 14 may. de 2024, 14:25:35
    Author     : DELL
--%>

<%@page import="com.mycompany.crud_blog.modelo.Blog"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("seminarios") == null) {
        ArrayList<Blog> blogs = new ArrayList<>();
        session.setAttribute("blogs", blogs);
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Blog de Tecnologia</h1>
        <a href="servBlog?op=create">Nueva entrada</a>
        <ul>
            <c:forEach var="blog" items="${sessionScope.blogs}" >
                <li>blog.getTitulo()</li>
                <li>blog.getFecha()<
                <li>blog.getContenido()</li> 
                <ul>
                    <li><a href="servBlog?op=update">Actualizar</a></li>
                    <li><a href="servBlog?op=delete">Eliminar</a></li>                    
                </ul>

                <hr>
            </c:forEach>

        </ul>

    </body>
</html>
