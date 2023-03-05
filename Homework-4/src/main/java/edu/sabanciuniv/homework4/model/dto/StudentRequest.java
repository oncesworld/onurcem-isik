package edu.sabanciuniv.homework4.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {

    private String studentFirstName;
    private String studentLastName;
    private int age;
    private String updatedBy;

}
