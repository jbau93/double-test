package com.example.demo.domain.service;

import com.example.demo.dto.CreateTicketDto;
import com.example.demo.dto.TicketDto;
import com.example.demo.dto.UpdateTicketDto;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<TicketDto> findAll();
    TicketDto findById(long id);
    TicketDto update(UpdateTicketDto updateTicketDto);
    TicketDto create(CreateTicketDto createTicketDto);
    boolean deleteById(long id);
}
