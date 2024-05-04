package com.luotat.mapper;

import com.luotat.POJO.Crs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface CrsMapper
{
    /**
     * 插入课程
     *
     * @param crs 对象
     */
    @Insert("insert into Course(name, open_time, close_time, create_time, class_id) " +
            "values (#{name}, #{openTime}, #{closeTime}, now(), #{classId})")
    void insert(Crs crs);

    /**
     * 根据id删除课程
     *
     * @param id 课程id
     */
    @Delete("delete from Course " +
            "where id = #{id}")
    void delete(Integer id);


    /**
     * 根据id修改课程信息
     *
     * @param crs 课程对象
     */
    void update(Crs crs);


    /**
     * 根据id查询课程信息
     *
     * @param id 课程id
     */
    @Select("select id, name, open_time, close_time, create_time, class_id " +
            "from Course " +
            "where id = #{id}")
    Crs getById(Integer id);


    /**
     * 条件查询课程
     *
     * @param name  姓名
     * @param begin 结课时间起始
     * @param end   结课时间结束
     * @return 课程对象
     */
    List<Crs> list(String name, LocalDate begin, LocalDate end);
}
