package com.example.quotes.controller;

import com.example.quotes.model.Quote;
import com.example.quotes.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/random")
    public Quote getRandom(){
        return quoteService.getRandomQuote();
    }

    @GetMapping("/{id}")
    public Quote getQuote(@PathVariable String id) {
        return quoteService.getQuoteById(Long.parseLong(id));
    }
}
