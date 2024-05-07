package com.luotat.mapper;

import com.luotat.POJO.Cls;
import com.luotat.POJO.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClsMapper
{
    /**
     * 插入班级
     *
     * @param cls 班级对象
     */
    @Insert("insert into Class(name, room, teacher, open_time, close_time, create_time) " +
            "values (#{name}, #{room}, #{teacher}, #{openTime}, #{closeTime}, now())")
    void insert(Cls cls);

    /**
     * 根据id删除班级
     *
     * @param id 班级id
     */
    @Delete("delete from Class " +
            "where id = #{id}")
    void delete(Integer id);

    /**
     * 根据id修改班级信息
     *
     * @param cls 班级对象
     */
    void update(Cls cls);

    /**
     * 根据id查询班级信息
     *
     * @param id 班级id
     */
    @Select("select id, name, room, teacher, open_time, close_time, create_time " +
            "from Class " +
            "where id = #{id}")
    Cls getById(Integer id);

    /**
     * 条件查询班级
     *
     * @param name  姓名
     * @param begin 结班时间起始
     * @param end   结班时间结束
     * @return 班级对象
     */
    List<Emp> list(String name, LocalDate begin, LocalDate end);
}
