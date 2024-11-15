package br.edu.fatecsjc.lgnspringapi.entity;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {
    private String number;
    private String street;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
}
