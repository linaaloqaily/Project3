package com.example.project3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Book {

    @Id
    @NotNull(message = "id is required")
    private Integer id;

    @NotEmpty(message = "name is required")
    private String name;

    @NotEmpty(message = "genre is required")
    private String genre;


    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    private Set<Loan> loans;
}
