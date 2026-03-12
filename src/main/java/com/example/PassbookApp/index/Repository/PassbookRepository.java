package com.example.PassbookApp.index.Repository;

import com.example.PassbookApp.index.Entity.PassbookEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PassbookRepository {
    @Select("SELECT id,date,category,method,amount,Continue AS cont,memo FROM passbook WHERE YEAR(date) = #{year} AND MONTH(date) = #{month}")
    List<PassbookEntity> findByYearMonth(@Param("year")int year, @Param("month") int month);

}
