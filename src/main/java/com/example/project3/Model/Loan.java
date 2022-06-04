package com.example.project3.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Loan {

    @Id
    @NotNull(message = "id is required")
    private Integer id;

    @NotNull(message = "userid is required")
    private Integer userid;

    @NotNull(message = "bookid is required")
    private Integer bookid;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Book> books;
}
