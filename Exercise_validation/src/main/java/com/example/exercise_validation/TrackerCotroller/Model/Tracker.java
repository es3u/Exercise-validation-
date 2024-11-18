package com.example.exercise_validation.TrackerCotroller.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Primary;

@Data
@AllArgsConstructor
public class Tracker {


    @NotNull(message = "id can not be null")
    @Min(value = 1 , message = "Please enter greater than 1")
    @Max(value = 2,message = "Please enter less than 2 ")
    private int id;
    @NotEmpty(message = "title can not be empty")
    @Size(min = 0, max = 8)
    private String title;
    @NotEmpty(message = "description can not be empty")
    @Size(min = 0, max = 15)
    private String description;
    @NotEmpty(message = "status can not be empty")
    @Pattern(regexp = "^(Not Started|Progress|Completed)$", message = "Status must be 'Not Started', 'In Progress' or 'Completed'")
    private String status;
    @NotEmpty(message = "company name can not be empty")
    @Size(min = 0, max = 6)
    private String companyName;

}
