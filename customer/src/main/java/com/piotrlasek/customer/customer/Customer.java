package com.piotrlasek.customer.customer;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;
}
