package com.example.calc;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Data
@Getter
@Setter
public class Rate {
    String currency;
    String node;
    BigDecimal mid;
}
