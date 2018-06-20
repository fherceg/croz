package App.Services;

import App.Entities.Joke;
import App.Repositories.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
        Collections.sort(allJokes);
        return allJokes;
    }

    public List<Joke> getJokesPage(Integer pageNumber){
        ArrayList<Joke> jokesPage = new ArrayList<>();
        Integer lastIndex;
        if(pageNumber <= 0){
            return new ArrayList<Joke>();
        }
        if(pageNumber - 1  > this.getJokeRepositoryList().size()/10){
            return new ArrayList<Joke>();
        }
        lastIndex = pageNumber*10;
        if(lastIndex > this.getJokeRepositoryList().size()){
            lastIndex = this.getJokeRepositoryList().size();
        }
        jokesPage.addAll(this.getJokeRepositoryList().subList(10*(pageNumber-1), lastIndex));
        return jokesPage;
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
