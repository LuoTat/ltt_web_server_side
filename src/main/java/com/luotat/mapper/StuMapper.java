package com.luotat.mapper;

import com.luotat.POJO.GenderBean;
import com.luotat.POJO.Stu;
import com.luotat.POJO.educationLevelBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuMapper
{
    /**
     * 插入学生
     *
     * @param stu 用户对象
     */
    @Insert("insert into Student(name, student_id, gender, phone_number, education_level, create_time, update_time, class_id) " +
            "values (#{name}, #{studentId}, #{gender}, #{phoneNumber}, #{educationLevel},  now(), now(), #{classId})")
    void insert(Stu stu);

    /**
     * 根据id删除学生
     *
     * @param ids 学生ids
     */
    void delete(List<Integer> ids);

    /**
     * 根据id修改学生信息
     *
     * @param stu 用户对象
     */
    void update(Stu stu);

    /**
     * 返回男女学员数量
     *
     * @return GenderBean
     */
    @Select("select gender, count(*) as count " +
            "from Student " +
            "group by gender")
    List<GenderBean> getGenderCount();

    /**
     * 返回不同educationLevel人数
     *
     * @return educationLevelBean
     */
    @Select("select education_level, count(*) as count " +
            "from Student " +
            "group by education_level")
    List<educationLevelBean> getEducationLevelCount();

    /**
     * 根据id查询学生信息
     *
     * @param id 学生id
     */
    @Select("select id, name, student_id, gender, phone_number, education_level, infraction_num, infraction_point, create_time, update_time, class_id " +
            "from Student " +
            "where id = #{id}")
    Stu getById(Integer id);

    /**
     * 条件查询学生
     *
     * @param name           姓名
     * @param studentId      学号
     * @param educationLevel 学生学历
     * @param classId        学生班级id
     * @return 用户对象
     */
    List<Stu> list(String name, String studentId, Short educationLevel, Short classId);
}