package com.example.springbatch.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PayDto {
    private Long amount;
    private String txName;
    private LocalDateTime txDateTime;
}
