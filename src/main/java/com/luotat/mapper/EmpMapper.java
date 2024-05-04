package com.luotat.mapper;

import com.luotat.POJO.Emp;
import com.luotat.POJO.GenderBean;
import com.luotat.POJO.JobBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper
{
    /**
     * 登录
     *
     * @param emp 用户对象
     * @return 用户对象
     */
    @Select("select id, username, name, gender, image, job, entry_date, create_time, update_time, dept_id " +
            "from Employee " +
            "where username=#{username} and password =#{password}")
    Emp login(Emp emp);


    /**
     * 插入员工
     *
     * @param emp 用户对象
     */
    @Insert("insert into Employee(username, name, gender, image, job, entry_date, create_time, update_time, dept_id) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entryDate}, now(), now(), #{deptId})")
    void insert(Emp emp);

    /**
     * 根据id删除员工
     *
     * @param ids 员工ids
     */
    void delete(List<Integer> ids);

    /**
     * 根据id修改员工信息
     *
     * @param emp 员工对象
     */
    void update(Emp emp);

    /**
     * 检查密码
     *
     * @param id       员工id
     * @param password 密码
     */
    @Select("SELECT IF(password = #{password}, 1, 0) FROM Employee WHERE id = #{id}")
    boolean checkPassword(Integer id, String password);

    /**
     * 修改密码
     *
     * @param id       员工id
     * @param password 新密码
     */
    @Select("update Employee " +
            "set password = #{password} " +
            "where id = #{id}")
    void changePassword(Integer id, String password);

    /**
     * 返回男女员工数量
     *
     * @return GenderBean
     */
    @Select("select gender, count(*) as count " +
            "from Employee " +
            "group by gender")
    List<GenderBean> getGenderCount();

    /**
     * 返回不同Job人数
     *
     * @return JobBean
     */
    @Select("select job, count(*) as count " +
            "from Employee " +
            "group by job")
    List<JobBean> getJobCount();

    /**
     * 根据id查询员工信息
     *
     * @param id 员工id
     */
    @Select("select id, username, name, gender, image, job, entry_date, create_time, update_time, dept_id " +
            "from Employee " +
            "where id = #{id}")
    Emp getById(Integer id);


    /**
     * 条件查询员工
     *
     * @param name   姓名
     * @param gender 性别
     * @param begin  入职日期起始
     * @param end    入职日期结束
     * @return 用户对象
     */
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
}