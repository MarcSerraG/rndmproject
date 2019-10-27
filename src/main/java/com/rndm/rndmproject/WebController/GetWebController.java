package com.rndm.rndmproject.WebController;

import com.rndm.rndmproject.Controller.CategoryUseCases;
import com.rndm.rndmproject.Controller.ThreadUseCases;
import com.rndm.rndmproject.domain.Thread;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class GetWebController {

    private ThreadUseCases threadUseCases;
    private CategoryUseCases categoryUseCases;

    public GetWebController(ThreadUseCases threadUseCases, CategoryUseCases categoryUseCases){
        this.threadUseCases = threadUseCases;
        this.categoryUseCases = categoryUseCases;
    }

    @GetMapping("/")
    public String firstThreads (Model model){
        model.addAttribute("IndexThread", threadUseCases.findFirstTen());
        model.addAttribute("Categories", categoryUseCases.findCategories());
        return "index";
    }


    @GetMapping("/{page}")
    public String firstThreads (Model model, @PathVariable int page){
        model.addAttribute("IndexThread", threadUseCases.findXThreads(page));
        return "index";
    }

    @GetMapping("/Category/{category}")
    public String FindByCategory (Model model, @PathVariable String category){
        model.addAttribute("IndexThread", threadUseCases.findThreadByCategory(category));
        model.addAttribute("Categories", categoryUseCases.findCategories());
        return"index";
    }


}
