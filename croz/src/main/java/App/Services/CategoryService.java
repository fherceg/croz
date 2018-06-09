package App.Services;

import App.Entities.Category;
import App.Entities.Joke;
import App.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Joke joke){
        Optional<Category> category = categoryRepository.findById(joke.getId());
        return category.get();
    }

    public Iterable<Category> getCategoryRepository() {
        return categoryRepository.findAll();
    }

}
