package com.piotrlasek.customer.domain;



import lombok.*;

import javax.persistence.*;

@Entity(name = "customer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;
}
