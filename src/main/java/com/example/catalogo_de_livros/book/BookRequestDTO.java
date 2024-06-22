package com.example.catalogo_de_livros.book;

public record BookRequestDTO(String title, String description,String author , String image,Integer price) {
}
