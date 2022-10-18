package com.example.demo.entity;


import com.example.demo.dto.TicketDto;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "is_open", nullable = false)
    private Boolean isOpen;
    @CreationTimestamp
    @Column(name = "created")
    private Timestamp created;

    @UpdateTimestamp
    @Column(name = "updated")
    private Timestamp updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public TicketDto toTicketDto(Ticket ticket){
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(ticket, TicketDto.class);
    }
}
