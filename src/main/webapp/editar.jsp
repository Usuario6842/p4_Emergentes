<%-- 
    Document   : editar
    Created on : 14 may. de 2024, 14:37:15
    Author     : DELL
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.crud_blog.modelo.Blog"%>
<%
    List<Blog> blogs = (List<Blog>) session.getAttribute("blogs");
    int actId = Integer.parseInt(request.getAttribute("lastId").toString());
    int id = actId + 1;
    request.setAttribute("nextId", id);
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nueva Entrada</h1>
        <form action="servBlog" method="post">
            <br><label>Id</label>
            <input type="number" name="id" value="<c:out value="${requestScope.actualBlog.getId()}" default="${requestScope.nextId}"  />" readonly ><br><br>
            <label>Fecha</label>
            <input type="date" name="fecha" value="<c:out value="${requestScope.actualBlog.getFecha()}" />" required><br><br>
            <label>Titulo</label>
            <input type="text" name="titulo" value="<c:out value="${requestScope.actualBlog.getTitulo()}" />" required><br><br>
            <label>Contenido</label>
            <textarea id="id" name="contenido" rows="5" cols="10">
                <c:out value="${requestScope.actualBlog.getContenido()}" />
            </textarea>
            
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
