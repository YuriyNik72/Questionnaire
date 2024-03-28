package ru.nikitin.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Log4j2
@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category() {log.info("конструктор Category без параметров");
    }

    @Override
    public String toString() {
        return   categoryName;
    }
}
