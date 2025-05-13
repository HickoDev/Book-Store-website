package com.example.bookstore.services;

import com.example.bookstore.models.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
@RequiredArgsConstructor
public class CartService {
    private final List<Book> items = new ArrayList<>();
    private final BookService bookService;

    public void addItem(Long bookId) {
        Book book = bookService.getBookById(bookId);
        items.add(book);
    }

    public void removeItem(Long bookId) {
        items.removeIf(book -> book.getId().equals(bookId));
    }

    public List<Book> getItems() {
        return new ArrayList<>(items);
    }

    public void clear() {
        items.clear();
    }

    public BigDecimal getTotal() {
        return items.stream()
                .map(Book::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
} 