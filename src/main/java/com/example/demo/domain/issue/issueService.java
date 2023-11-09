package com.example.demo.domain.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class issueService {
    private final issueRepositry repo;
@Transactional
    public void create(String summury, String description) {
        repo.insert (summury,description);

    }


    public List<issueEntity>findAll(){
        return repo.findAll();
    }

    public issueEntity findById(long issueId) {
    return repo.findById(issueId);
    }


    //送信するだけ、ロジックを分けるために使用
    };
