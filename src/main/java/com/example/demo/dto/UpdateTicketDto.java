package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@With
@Data
@AllArgsConstructor
public class UpdateTicketDto {
    private final long id;
    private final long userId;
    private final boolean isOpen;
}
