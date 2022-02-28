package com.example.quotes.service;

import com.example.quotes.model.Quote;
import com.example.quotes.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class QuoteService {

    private static final int MAX_QUOTES = 25;
    private final Random random = new Random();

    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote getRandomQuote() {
        return quoteRepository.findById((long) random.nextInt(MAX_QUOTES) + 1).orElse(null);
    }

    public Quote getQuoteById(Long id) {
        return quoteRepository.findById(id).orElse(null);
    }
}
