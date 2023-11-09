package com.example.demo.web;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class issueForm {
    @NotBlank
    @Size(max=256)
    private String summury;
    @NotBlank
    @Size(max=256)
    private String description;
}
