package com.example.exercise_validation_q3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Event {
    @NotNull(message = "id can not be null")
    @Size(min = 1, max = 2 , message = "Please enter greater than 1 and less than 2")
    private int id;
    @NotEmpty(message = "description can not be empty")
    @Max(15)
    private String description;
    @NotNull(message = "capacity con not null")
    @Min(0)
    @Max(25)
    @Pattern(regexp = "^\\d+$", message = "Capacity must be a valid number")
    private int capacity;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startdate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date enddate;
}
