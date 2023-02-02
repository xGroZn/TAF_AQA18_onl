package sauceDemo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Data
@NoArgsConstructor
public class User {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String zipCode;
}