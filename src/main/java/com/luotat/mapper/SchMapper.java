package com.luotat.mapper;

import com.luotat.POJO.Sch;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchMapper
{
    /**
     * 插入课表
     *
     * @param sch 对象
     */
    @Insert("insert into Schedule(course_id, emp_id, create_time) " +
            "values (#{courseId}, #{empId}, now())")
    void insert(Sch sch);

    /**
     * 根据id删除课表
     *
     * @param id 课表id
     */
    @Delete("delete from Schedule " +
            "where id = #{id}")
    void delete(Integer id);


    /**
     * 根据id修改课表信息
     *
     * @param sch 课表对象
     */
    void update(Sch sch);


    /**
     * 根据id查询课表信息
     *
     * @param id 课表id
     */
    @Select("select id, course_id, emp_id, create_time " +
            "from Schedule " +
            "where id = #{id}")
    Sch getById(Integer id);


    /**
     * 条件查询课表
     *
     * @param courseId 姓名
     * @param empId    结课时间起始
     * @return 课表对象
     */
    List<Sch> list(Integer courseId, Integer empId);
}
