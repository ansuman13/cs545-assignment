package com.miu.ansuman.assignment.first.lab.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User principle;

    private String operation;

    private String module;

}