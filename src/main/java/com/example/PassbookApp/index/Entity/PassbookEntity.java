package com.example.PassbookApp.index.Entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PassbookEntity {
    private Long id;
    private LocalDate date;
    private Category category;
    private Method method;
    private int amount;
    private Continue cont;
    private String memo;

}
