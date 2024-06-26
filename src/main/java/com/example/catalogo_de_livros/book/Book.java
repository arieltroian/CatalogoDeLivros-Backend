package com.example.catalogo_de_livros.book;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "books")
@Entity(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String title;
    private String author;
    private String image;
    private Integer price;

    public Book(BookRequestDTO data){
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
        this.author = data.author();
    }

    public void updateFromDTO(BookRequestDTO data) {
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
        this.author = data.author();
    }
}
