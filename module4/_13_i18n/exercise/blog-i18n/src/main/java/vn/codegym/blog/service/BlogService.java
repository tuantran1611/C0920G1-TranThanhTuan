package vn.codegym.blog.service;

import vn.codegym.blog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    void save(Blog blog);
    Blog findById(int id);
    void delete(int id);
    List<Blog> findAllByNameContaining(String name);
}
