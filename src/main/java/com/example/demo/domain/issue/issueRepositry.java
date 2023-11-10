package com.example.demo.domain.issue;




import org.apache.ibatis.annotations.*;
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
//@Update("Update issues set summury= #{summury} ,description= #{description} where id= #{id}")
//    void update(@Param("id") long id, @Param("summury") String summury, @Param("description") String description);

@Delete("delete from issues  where id= #{issueId}")
    void delete(long issueId);
    @Update("ALTER TABLE issues AUTO_INCREMENT = 1;")
    void resetAutoIncrement();

}
