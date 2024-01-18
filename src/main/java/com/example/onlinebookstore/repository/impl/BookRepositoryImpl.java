package com.example.onlinebookstore.repository.impl;

import com.example.onlinebookstore.exception.DataProcessingException;
import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    @Override
    public Book save(Book book) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Cannot save to db book: " + book, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Book> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Book> bookQuery = session.createQuery("FROM Book", Book.class);
            return bookQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot get all books from db", e);
        }
    }

    @Override
    public Optional<Book> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Book> bookQuery = session.createQuery("FROM Book b"
                    + " WHERE b.id = :id", Book.class);
            bookQuery.setParameter("id", id);
            return Optional.ofNullable(bookQuery.getSingleResult());
        } catch (Exception e) {
            throw new DataProcessingException("Cannot get from db book by id: " + id);
        }
    }
}
