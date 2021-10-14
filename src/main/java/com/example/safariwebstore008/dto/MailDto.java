package com.example.safariwebstore008.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailDto {
    private String to;
    private String subject;
    private String body;
}
