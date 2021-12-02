package com.hackerrank.springsecurity.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int bookId;
    private String bookName;
    private String nameOfAuthor;
    private String tagNumber;
    private List<String> prerequisites;

}
