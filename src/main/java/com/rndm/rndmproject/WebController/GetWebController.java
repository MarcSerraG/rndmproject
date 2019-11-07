package com.rndm.rndmproject.WebController;

import com.rndm.rndmproject.Controller.CategoryUseCases;
import com.rndm.rndmproject.Controller.ThreadUseCases;
import com.rndm.rndmproject.domain.Thread;
import com.rndm.rndmproject.persistence.CommentDAO;
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
    private CommentDAO commentDAO;

    public GetWebController(ThreadUseCases threadUseCases, CategoryUseCases categoryUseCases, CommentDAO commentDAO){
        this.threadUseCases = threadUseCases;
        this.categoryUseCases = categoryUseCases;
        this.commentDAO = commentDAO;
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

    @GetMapping("/Thread/{id}")
    public String LoadThread (Model model, @PathVariable String id){
        model.addAttribute("threadByID", threadUseCases.getThread(id));
        model.addAttribute("Categories", categoryUseCases.findCategories());
        model.addAttribute("Comments", commentDAO.getCommentsByThread(id));
        return "thread";
    }

    @GetMapping("Search/{title}")
    public String FindThreadByName (Model model, @PathVariable String title){
        model.addAttribute("IndexThread", threadUseCases.findThreadByName(title));
        model.addAttribute("Categories", categoryUseCases.findCategories());
        return"index";
    }


}
