package com.example.demo.domain.issue;

import lombok.AllArgsConstructor;
import lombok.Data;



public class issueEntity {
    public issueEntity(){};
//    public issueEntity(long id, String summury, String description) {
//        this.id = id;
//        this.summury = summury;
//        this.description = description;
//    }

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    private String summury;
    private String description;

}
