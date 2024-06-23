package com.example.catalogo_de_livros.book;

public record BookResponseDTO(Long id, String title, String author , String image, Integer price) {
    public BookResponseDTO(Book book){
        this(book.getId(), book.getTitle(), book.getAuthor(), book.getImage(), book.getPrice());
    }
}
