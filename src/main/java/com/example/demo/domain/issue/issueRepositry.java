package com.example.demo.domain.issue;




import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Mapper
public interface issueRepositry {
    @Insert("insert into issues (summury,description)values (#{summury},#{description})")
   void insert(String summury, String description);


    @Select("select* from ISSUES ")
   List<issueEntity> findAll();
    @Select("select * from issues where id= #{issueId} ")
    issueEntity findById(long issueId);
}
