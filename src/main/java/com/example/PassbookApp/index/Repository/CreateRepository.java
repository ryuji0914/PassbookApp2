package com.example.PassbookApp.index.Repository;

import com.example.PassbookApp.index.Entity.CreateEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CreateRepository {
    @Select("SELECT id,category,method,amount,Continue AS cont,memo,date FROM passbook;")
    public List<CreateEntity> select();

    @Select("SELECT COALESCE(SUM(amount),0) FROM passbook")
    int sumAmount();

    @Insert("""
    INSERT INTO passbook (category,method,amount,Continue,memo,date)
    VALUES (#{passbook.category},#{passbook.method},#{passbook.amount},#{passbook.cont},#{passbook.memo},#{passbook.date})
    """)
    void create(@Param("passbook") CreateEntity createentity);

   // <insert id="insert" parameterType="CreateEntity">
   // INSERT INTO table (category, method, amount, cont, memo)
   // VALUES (#{category}, #{method}, #{amount}, #{Continue}, #{memo})
//</insert>

}
