package App.Services;

import App.Entities.Joke;
import App.Repositories.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JokeService {
    @Autowired
    private JokeRepository jokeRepository;

    public List<Joke> getJokeRepositoryList() {
        ArrayList<Joke> allJokes = new ArrayList<>();
        for (Joke i : jokeRepository.findAll()){
            allJokes.add(i);
        }
        return allJokes;
    }

    public Joke findByContent(String content){
        List<Joke> jokes = jokeRepository.findByContent(content);
        return jokes.get(0);
    }

    public boolean like(Joke joke){
        jokeRepository.save(joke.like());
        return true;
    }
    public boolean dislike(Joke joke){
        jokeRepository.save(joke.dislike());
        return true;
    }
}
