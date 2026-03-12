package com.example.PassbookApp.index.Entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateForm(
    @NotNull
    String category,
    @NotNull
    String method,
    int amount,
    @NotNull
    String cont,
    String memo,
    int year,
    int month,
    String date
) {
    public CreateEntity createEntity(){
        return new CreateEntity
                (null,Category.valueOf(category()),Method.valueOf(method()),amount(),Continue.valueOf(cont()),memo(), LocalDate.parse(date));
    }


}
