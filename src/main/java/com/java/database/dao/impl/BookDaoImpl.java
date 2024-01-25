package com.java.database.dao.impl;

import com.java.database.dao.BookDao;
import com.java.database.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update(
                "INSERT INTO book (isbn, title, authorId) VALUES (?, ?, ?)",
                book.getIsbn(), book.getTitle(), book.getAuthorId()
        );
    }
}
