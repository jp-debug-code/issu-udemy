package com.example.demo.domain.issue;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class issueEntity {
    private long id;
    private String summury;
    private String description;

}
