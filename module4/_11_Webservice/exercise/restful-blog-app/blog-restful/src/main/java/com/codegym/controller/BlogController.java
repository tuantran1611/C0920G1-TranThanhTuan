package com.codegym.controller;


import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.print.attribute.standard.Media;


@RestController
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping(value = {"","/"})
    public ResponseEntity<Page<Blog>> showList(Pageable pageable, Model model) {
        Page<Blog> blogs = blogService.findAll(pageable);
        if (blogs.isEmpty()){
            return new ResponseEntity<Page<Blog>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Page<Blog>>(blogs, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlog(@PathVariable("id") Long id) {
        System.out.println("Fetching Blog with id " + id);
        Blog blog = blogService.findOne(id);
        if (blog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<Void> create(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
        blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/blog/create/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Blog>  editBlog(@PathVariable("id") Long id, @RequestBody Blog blog) {
        Blog bl = blogService.findOne(id);

        if (bl == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        bl.setContent(blog.getContent());
        bl.setDescription(blog.getDescription());
        bl.setId(blog.getId());
        blogService.save(bl);
        return new ResponseEntity<Blog>(bl, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
        public ResponseEntity<Blog> delete(@PathVariable("id") Long id, Pageable pageable, Model model) {

            System.out.println("Fetching & Deleting Customer with id " + id);

            Blog blog = blogService.findOne(id);
            if (blog == null) {
                System.out.println("Unable to delete. Blog with id " + id + " not found");
                return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
            }
            blogService.delete(id);
            return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
        }
}
