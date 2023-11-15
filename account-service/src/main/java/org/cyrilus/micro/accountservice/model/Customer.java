package org.cyrilus.micro.accountservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Builder
public class Customer {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
