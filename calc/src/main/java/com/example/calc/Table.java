package com.example.calc;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
public class Table {
    String table;
    String no;
    LocalDate effectiveDate;
    Rate[] rates;
}
