package com.example.onlinebookstore.repository;

import com.example.onlinebookstore.model.Book;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.author = :author, b.title = :title, "
            + "b.price = :price, b.description = :description, b.coverImage = :coverImage "
            + "WHERE b.id = :id")
    void updateBook(Long id, String author, String title, BigDecimal price,
                    String description, String coverImage);
}
