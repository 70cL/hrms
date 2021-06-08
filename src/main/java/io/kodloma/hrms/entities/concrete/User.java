package io.kodloma.hrms.entities.concrete;

import io.kodloma.hrms.entities.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @NotEmpty(message = "Mail may not be empty")
    private String mail;

    @Column(name = "password")
    @NotBlank(message = "Password may not be empty")
    @Size(min = 6, max = 12, message = "Password must be between 6 and 12 characters long")
    private String password;
}
