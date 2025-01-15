package com.quiz.iqquiz.service.impl;

import com.quiz.iqquiz.model.Category;
import com.quiz.iqquiz.repository.CategoryRepository;
import com.quiz.iqquiz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    @Override
    public Category updateCategory(Integer id, Category categoryDetails) {
        Category category = getCategoryById(id);
        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
