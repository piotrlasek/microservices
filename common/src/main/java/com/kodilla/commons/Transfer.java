package com.kodilla.commons;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transfer {
    private String senderAccount;
    private String recipientAccount;
    private String title;
    private BigDecimal amount;
}
