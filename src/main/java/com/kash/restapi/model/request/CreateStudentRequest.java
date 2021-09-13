package com.kash.restapi.model.request;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class CreateStudentRequest {

    @JsonProperty("first_name")
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    private String lastName;

    private String email;

}
