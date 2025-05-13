package com.example.bookstore.services;

import com.example.bookstore.models.Book;
import com.example.bookstore.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void getAllBooks_ShouldReturnAllBooks() {
        // Arrange
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Test Book 1");
        book1.setAuthor("Test Author 1");
        book1.setPrice(new BigDecimal("9.99"));

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Test Book 2");
        book2.setAuthor("Test Author 2");
        book2.setPrice(new BigDecimal("19.99"));

        List<Book> expectedBooks = Arrays.asList(book1, book2);
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> actualBooks = bookService.getAllBooks();

        // Assert
        assertThat(actualBooks).hasSize(2);
        assertThat(actualBooks).containsExactlyElementsOf(expectedBooks);
    }

    @Test
    void getBookById_ShouldReturnBook_WhenBookExists() {
        // Arrange
        Book expectedBook = new Book();
        expectedBook.setId(1L);
        expectedBook.setTitle("Test Book");
        expectedBook.setAuthor("Test Author");
        expectedBook.setPrice(new BigDecimal("9.99"));

        when(bookRepository.findById(1L)).thenReturn(Optional.of(expectedBook));

        // Act
        Book actualBook = bookService.getBookById(1L);

        // Assert
        assertThat(actualBook).isNotNull();
        assertThat(actualBook.getId()).isEqualTo(expectedBook.getId());
        assertThat(actualBook.getTitle()).isEqualTo(expectedBook.getTitle());
        assertThat(actualBook.getAuthor()).isEqualTo(expectedBook.getAuthor());
        assertThat(actualBook.getPrice()).isEqualTo(expectedBook.getPrice());
    }
} 