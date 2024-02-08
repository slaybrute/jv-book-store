package com.example.onlinebookstore.repository.category;

import com.example.onlinebookstore.model.Category;
import java.util.Optional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

    void deleteById(@NonNull Long id);
}
