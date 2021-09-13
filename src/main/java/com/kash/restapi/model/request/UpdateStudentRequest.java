package com.kash.restapi.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UpdateStudentRequest {


    @NotBlank(message = "Student can't be update without Id")
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

}
