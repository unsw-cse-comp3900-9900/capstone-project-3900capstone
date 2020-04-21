package com.project.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    private Integer bookId;
    private String bookName;
    private float price;
    private int bookCounts;
    private String detail;
    private String publisher;
    private String author;
    private String photoAddress;
    private int clickTime;
    private String department;
    private Integer adminId;
}
