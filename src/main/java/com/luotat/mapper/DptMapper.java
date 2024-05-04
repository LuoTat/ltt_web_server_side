package com.luotat.mapper;

import com.luotat.POJO.Dpt;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DptMapper
{
    /**
     * 插入部门
     *
     * @param Dpt 部门对象
     */
    @Insert("insert into Department(name, create_time, update_time) " +
            "values (#{name}, now(), now())")
    void insert(Dpt Dpt);

    /**
     * 根据id删除部门
     *
     * @param id 部门id
     */
    @Delete("delete from Department " +
            "where id = #{id}")
    void delete(Integer id);

    /**
     * 根据id修改部门信息
     *
     * @param Dpt 部门对象
     */
    @Update("update Department " +
            "set name=#{name}, update_time=now() " +
            "where id=#{id}")
    void update(Dpt Dpt);

    /**
     * 根据id查询员工信息
     *
     * @param id 用户对象
     */
    @Select("select id, name " +
            "from Department " +
            "where id = #{id}")
    Dpt getById(Integer id);

    /**
     * 获得所有部门
     *
     * @return 部门对象
     */
    @Select("select id, name, create_time, update_time " +
            "from Department " +
            "order by update_time DESC")
    List<Dpt> list();
}
