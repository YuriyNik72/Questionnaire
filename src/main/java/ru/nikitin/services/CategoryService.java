package ru.nikitin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikitin.entities.Category;
import ru.nikitin.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository catrepo;

    @Autowired
    public void setCategoryRepository(CategoryRepository catrepo) {
        this.catrepo = catrepo;
    }

    public List<Category> getAllCategories() {
        return catrepo.findAll();
    }

    public Category get (Long id){
        return catrepo.findById(id).get();
    }
}
