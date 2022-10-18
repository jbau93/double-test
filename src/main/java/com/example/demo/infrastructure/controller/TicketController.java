package com.example.demo.infrastructure.controller;

import com.example.demo.domain.service.TicketService;
import com.example.demo.dto.CreateTicketDto;
import com.example.demo.dto.TicketDto;
import com.example.demo.dto.UpdateTicketDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("all")
    public ResponseEntity<List<TicketDto>> all() {
        final List<TicketDto> tickets = ticketService.findAll();

        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketDto> findById(@PathVariable long ticketId) {
        final TicketDto ticket = ticketService.findById(ticketId);

        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<TicketDto> update(
            @PathVariable long ticketId,
            @RequestBody UpdateTicketDto updateTicketDto
    ) {
        final TicketDto ticket = ticketService.update(updateTicketDto.withId(ticketId));

        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TicketDto> create(@RequestBody CreateTicketDto createTicketDto){
        final TicketDto ticket = ticketService.create(createTicketDto);

        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable long ticketId) {
        ticketService.deleteById(ticketId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
