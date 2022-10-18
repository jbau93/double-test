package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@With
@Data
@AllArgsConstructor
public class CreateTicketDto {
    private final long userId;
    private final boolean isOpen;
}
