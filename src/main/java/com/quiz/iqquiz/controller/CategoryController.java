package com.quiz.iqquiz.controller;

import com.quiz.iqquiz.model.Category;
import com.quiz.iqquiz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class  CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping()
    public Category addCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }


    @GetMapping()
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }


    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
