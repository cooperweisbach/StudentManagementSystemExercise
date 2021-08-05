package org.perscholas.studentmanagementsystemexercise.models;


import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NonNull
    @NotBlank
    String name;

    @NonNull
    @NotBlank
    String instructor;


}
