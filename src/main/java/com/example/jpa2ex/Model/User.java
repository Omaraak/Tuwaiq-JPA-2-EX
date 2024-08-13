package com.example.jpa2ex.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 4)
    @Column(columnDefinition = "varchar(10) not null")
    private String name;

    @NotEmpty
    @Size(min = 4)
    @Column(columnDefinition = "varchar(10) not null unique")
    private String username;

    @NotEmpty
    @Size(min = 9, max = 9)
    @Column(columnDefinition = "varchar(9) not null")
    private String password;

    @NotEmpty
    @Email
    @Column(columnDefinition = "varchar(15) not null unique")
    private String email;

    @NotEmpty
    @Pattern(regexp = "(admin|user)")
    @Column(columnDefinition = "varchar(5) not null ")
    private String role;

    @NotNull
    @Positive
    @Column(columnDefinition = "int not null")
    private int age;
}
