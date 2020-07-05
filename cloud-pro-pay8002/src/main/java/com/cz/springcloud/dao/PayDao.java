package com.cz.springcloud.dao;


import com.cz.springcloud.utils.PageData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//@Repository注解在插入的时候可能会有问题，最好用下面的注解
@Mapper
public interface PayDao {

        @Insert("insert into payment (ls) values (#{ls})")
        void addPayment(@Param("ls") String ls);


        @Select("select * from payment where id = #{id}")
        PageData getById(@Param("id") Integer id);


}
