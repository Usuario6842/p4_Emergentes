/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crud_blog.dao;

import com.mycompany.crud_blog.modelo.Blog;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface BlogDAO {
    
    public void insert(Blog blog);
    public void update(Blog blog);
    public void delete(int id);
    public List<Blog> getAll();
    public Blog getById(int id);
    
            
}
