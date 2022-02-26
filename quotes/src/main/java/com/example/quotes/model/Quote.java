package com.example.quotes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quotes")
@Data
@NoArgsConstructor
public class Quote {
    @Id
    private Long id;
    private String author;
    private String content;
}
