package edu.sabanciuniv.homework4.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private int age;
    private LocalDateTime createdAt;

}
