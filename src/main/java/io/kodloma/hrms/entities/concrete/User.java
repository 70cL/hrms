package io.kodloma.hrms.entities.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @Email(message = "mail is not valid")
    @NotEmpty(message = "Mail can not be empty")
    @NotNull
    private String mail;

    @Column(name = "password")
    @NotBlank(message = "Password can not be empty")
    @NotNull
    @Size(min = 6, max = 12, message = "Password must be between 6 and 12 characters long")
    private String password;
}
