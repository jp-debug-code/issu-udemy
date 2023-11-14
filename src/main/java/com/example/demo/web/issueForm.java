package com.example.demo.web;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class issueForm {





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private Long id;
    @NotBlank
    @Size(max=256)
    private String summury;
    @NotBlank
    @Size(max=256)
    private String description;

    public String getSummury() {
        return summury;
    }

    public void setSummury(String summury) {
        this.summury = summury;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
}
