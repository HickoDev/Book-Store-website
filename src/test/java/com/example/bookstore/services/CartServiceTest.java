package com.example.bookstore.services;

import com.example.bookstore.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private CartService cartService;

    private Book testBook;

    @BeforeEach
    void setUp() {
        testBook = new Book();
        testBook.setId(1L);
        testBook.setTitle("Test Book");
        testBook.setAuthor("Test Author");
        testBook.setPrice(new BigDecimal("9.99"));
    }

    @Test
    void addItem_ShouldAddBookToCart() {
        // Arrange
        when(bookService.getBookById(1L)).thenReturn(testBook);

        // Act
        cartService.addItem(1L);

        // Assert
        assertThat(cartService.getItems()).hasSize(1);
        assertThat(cartService.getItems().get(0)).isEqualTo(testBook);
    }

    @Test
    void removeItem_ShouldRemoveBookFromCart() {
        // Arrange
        when(bookService.getBookById(1L)).thenReturn(testBook);
        cartService.addItem(1L);

        // Act
        cartService.removeItem(1L);

        // Assert
        assertThat(cartService.getItems()).isEmpty();
    }

    @Test
    void getTotal_ShouldCalculateCorrectTotal() {
        // Arrange
        when(bookService.getBookById(1L)).thenReturn(testBook);
        cartService.addItem(1L);
        cartService.addItem(1L); // Add same book twice

        // Act
        BigDecimal total = cartService.getTotal();

        // Assert
        assertThat(total).isEqualTo(new BigDecimal("19.98")); // 9.99 * 2
    }

    @Test
    void clear_ShouldRemoveAllItems() {
        // Arrange
        when(bookService.getBookById(1L)).thenReturn(testBook);
        cartService.addItem(1L);
        cartService.addItem(1L);

        // Act
        cartService.clear();

        // Assert
        assertThat(cartService.isEmpty()).isTrue();
        assertThat(cartService.getItems()).isEmpty();
    }
} 