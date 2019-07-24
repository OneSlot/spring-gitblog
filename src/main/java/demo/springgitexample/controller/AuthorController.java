package demo.springgitexample.controller;

import demo.springgitexample.model.Author;
import demo.springgitexample.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class AuthorController  {


    @Autowired
    private AuthorService authorService;

    //Model is view object for Spring
    //ModelAdnView
    //ModelMap
    //Model is used in only page....
    @GetMapping("/author")
    public String create(Model model){



        model.addAttribute("author",new Author());




        return "authorFrom";
    }


    @PostMapping("/author")
    public String process(Author author, BindingResult result){
        if(result.hasErrors()){
            return "authorForm";
        }

        authorService.create(author);

        return "redirect:/authors";
    }


    @GetMapping("/authors")
    public String showallAuthors(Model model){

        model.addAttribute("authors",authorService.findAll());
        return "authors";
    }
}
