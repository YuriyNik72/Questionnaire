package ru.nikitin.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nikitin.entities.Category;
import ru.nikitin.entities.Question;
import ru.nikitin.services.CategoryService;

import java.util.List;

@Data
@Controller
@RequestMapping("/themes")
public class ThemesController {

    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public String themesHome() {
        return "themes-panel";
    }

    @GetMapping("/category")
    public String categories(Model model){
        List<Category> categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "themes-panel";
    }


}
