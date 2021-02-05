package vn.codegym.blog.controller;

import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.service.BlogService;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blog")
    public String showList(Model model){
        model.addAttribute("listBlog", blogService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        blogService.delete(id);
        return "redirect:/blog";
    }

//    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
//    public ResponseEntity<List<Blog>> searchBlog(@PathVariable String name) {
//        List<Blog> blogs = blogService.findAllByNameContaining(name);
//        if(blogs == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        System.out.println(blogs);
//        return new ResponseEntity<>(blogs, HttpStatus.OK);
//
//    }

    @GetMapping("/search/{name}")
    public String search(@PathVariable String name, Model model){
        System.out.println(name);
        if(name == null && name.equals("")){
            model.addAttribute("listBlog", blogService.findAll());
        }else {
            model.addAttribute("listBlog", blogService.findAllByNameContaining(name));
        }
        return "search";
    }

}
