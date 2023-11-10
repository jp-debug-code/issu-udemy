package com.example.demo.domain.issue;

import lombok.RequiredArgsConstructor;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class issueService {
    private final issueRepositry repo;

    public issueService(issueRepositry repo) {
        this.repo = repo;
    }
    private static final Logger log = LoggerFactory.getLogger(issueService.class);
    @Transactional
    public void create(String summury, String description) {

            repo.insert(summury, description);
        }





    public List<issueEntity>findAll(){
        return repo.findAll();
    }

    public issueEntity findById(long issueId) {
    return repo.findById(issueId);
    }
//    @Transactional
//    public void update(long id,String summury, String description) {
//
//        repo.update(id,summury,description);
//    }
@Transactional
    public void delete(long issueId) {
        repo.delete(issueId);
        repo.resetAutoIncrement();

    }


    //送信するだけ、ロジックを分けるために使用
    };
