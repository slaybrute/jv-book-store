package com.example.onlinebookstore.dto.book;

import lombok.Data;

@Data
public class BookSearchParameters {
    private String[] titles;
    private String[] authors;
}
