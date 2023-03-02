package edu.sabanciuniv.homework4.model.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {

    private String studentFirstName;
    private String studentLastName;

}
