package App.Services;

import App.Entities.Joke;
import App.Entities.JokeForm;
import App.Repositories.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CreateJokeService {
    @Autowired
    private JokeRepository jokeRepository;

    public String addJoke(JokeForm jokeForm){
        Joke joke = new Joke();
        joke.setContent(jokeForm.getContent());
        joke.setId(jokeForm.getCategory());
        jokeRepository.save(joke);
        return "JokeForm.html";
    }

}
