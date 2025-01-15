package com.quiz.iqquiz.service;

import com.quiz.iqquiz.model.Category;
import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Integer id);
    Category updateCategory(Integer id, Category category);
    void deleteCategory(Integer id);
}
