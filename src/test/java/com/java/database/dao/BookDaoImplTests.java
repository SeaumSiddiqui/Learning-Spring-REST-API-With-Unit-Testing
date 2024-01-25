package com.java.database.dao;

import com.java.database.dao.impl.BookDaoImpl;
import com.java.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql() {
        Book book = Book.builder()
                .isbn("OCT-7-1948-2024-76")
                .title("The Ethnic Cleansing of Palestine")
                .authorId(1L)
                .build();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO book (isbn, title, authorId) VALUES (?, ?, ?)"),
                eq("OCT-7-1948-2024-76"),
                eq("The Ethnic Cleansing of Palestine"),
                eq(1L)
        );
    }
}
