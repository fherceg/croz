package App.Controllers;

import App.Entities.Joke;
import App.Services.CategoryService;
import App.Services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class ShowAllController {
    @Autowired
    private JokeService jokeService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAll(Model model){
        List<Joke> jokeList = jokeService.getJokeRepositoryList();
        Collections.sort(jokeList);
        model.addAttribute("jokes", jokeList);
        model.addAttribute("categoryService", categoryService);
        return "index";
    }

    @GetMapping("/error")
    public String getHome(){
        return "redirect:/";
    }

    @PostMapping("/error")
    public String postHome(){
        return "redirect:/";
    }


    @PostMapping(value="/like/{content}")
    public String likeJoke (@PathVariable String content) {
        jokeService.like(jokeService.findByContent(content));
        return "redirect:/";
    }
    @PostMapping(value="/dislike/{content}")
    public String dislikeJoke (@PathVariable String content) {
        jokeService.dislike(jokeService.findByContent(content));
        return "redirect:/";
    }
}
