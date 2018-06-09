package App.Repositories;

import App.Entities.Joke;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JokeRepository extends CrudRepository<Joke, Integer> {

    List<Joke> findByContent(String content);
}
