package com.summer.springboot.hbase.dao;

import com.summer.springboot.hbase.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Update;
import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("insert into `orders` (`id`, `price`, `detail`, `createTime`) " +
            "values(#{id},#{price},#{detail},#{createTime})")
    void save(Order order);

    @Select("select * from orders a where a.id = #{id}")
    Order findOrderById(@Param("id") Long id);


    @Update("update orders  set price = #{price}, detail = #{detail},createTime=#{createTime} " +
            "  where id= #{id}")
    void update(Order order);

    @Delete("delete from orders where id=#{id}")
    void delete(@Param("id") long id);


    @Select("select * from orders a ")
    List<Order> queryAll();
}
