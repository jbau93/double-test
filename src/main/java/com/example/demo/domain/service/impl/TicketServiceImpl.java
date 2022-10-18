package com.example.demo.domain.service.impl;

import com.example.demo.domain.service.TicketService;
import com.example.demo.dto.CreateTicketDto;
import com.example.demo.dto.TicketDto;
import com.example.demo.dto.UpdateTicketDto;
import com.example.demo.entity.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketDto> findAll() {
        return  ticketRepository.findAll().stream()
                .map(ticket -> ticket.toTicketDto(ticket))
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto findById(long id) {
        return ticketRepository.findById(id)
                .map(ticket -> ticket.toTicketDto(ticket))
                .get();
    }

    @Override
    public TicketDto update(UpdateTicketDto updateTicket) {
        final Ticket ticket = ticketRepository.findById(updateTicket.getId())
                .get();

        ticket.setOpen(updateTicket.isOpen());
        ticket.setUserId(updateTicket.getUserId());

        final Ticket ticketUpdate = ticketRepository.save(ticket);
        return ticketUpdate.toTicketDto(ticketUpdate);
    }
    @Override
    public TicketDto create(CreateTicketDto createTicketDto) {
        final Ticket ticket = new Ticket();
        ticket.setUserId(createTicketDto.getUserId());
        ticket.setOpen(createTicketDto.isOpen());

        System.out.println();

        final Ticket ticketCreate = ticketRepository.save(ticket);
        System.out.println();

        return ticketCreate.toTicketDto(ticketCreate);
    }

    @Override
    public boolean deleteById(long id) {
        ticketRepository.deleteById(id);

        return true;
    }
}
