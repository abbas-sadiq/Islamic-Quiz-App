package com.quiz.iqquiz.repository;

import com.quiz.iqquiz.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
