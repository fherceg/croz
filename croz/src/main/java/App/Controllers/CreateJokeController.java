package App.Controllers;


import App.Entities.Category;
import App.Entities.Joke;
import App.Entities.JokeForm;
import App.Services.CategoryService;
import App.Services.CreateJokeService;
import App.Services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class CreateJokeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CreateJokeService createJokeService;
    @Autowired
    private JokeService jokeService;

    @GetMapping("/new")
    public String newJokeForm(Model model){
        model.addAttribute("jokeForm", new JokeForm());
        model.addAttribute("categories", categoryService.getCategoryRepository());
        return "JokeForm";
    }

    @PostMapping("/new")
    public String processingJokeForm(@Valid JokeForm jokeForm, Model model){
        createJokeService.addJoke(jokeForm);

        return "redirect:/";
    }
}
