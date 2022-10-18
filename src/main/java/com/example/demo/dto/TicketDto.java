package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.sql.Timestamp;

@With
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private Long id;
    private Long userId;
    private boolean isOpen;
    private Timestamp created;
    private Timestamp updated;
}
