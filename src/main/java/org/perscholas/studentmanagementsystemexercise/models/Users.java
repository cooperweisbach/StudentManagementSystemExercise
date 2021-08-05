package org.perscholas.studentmanagementsystemexercise.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class Users implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @NonNull
    String email;

    @NotBlank(message="Please enter your name.")
    @NonNull
    String name;

    @NonNull
    @Pattern(message="Password must be atleast 8 characters, 1 Uppercase, 1 Lowercase, 1 digit, and a special character.", regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")
    String password;

    @OneToMany
    List<Course> course;

    //add Equals and Hashcode methods manually

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(name, users.name) && Objects.equals(email, users.email) && Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password);
    }


}
