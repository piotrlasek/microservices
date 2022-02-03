package com.piotrlasek.customer;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
}
