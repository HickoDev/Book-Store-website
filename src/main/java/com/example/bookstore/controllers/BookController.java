package com.example.bookstore.controllers;

import com.example.bookstore.services.BookService;
import com.example.bookstore.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final CartService cartService;

    @GetMapping({"/", "/books"})
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @PostMapping("/books/{id}/add")
    public String addToCart(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        cartService.addItem(id);
        redirectAttributes.addFlashAttribute("message", "Book added to cart");
        return "redirect:/books";
    }
} 