package dao;

import entity.Student;

/**
 * dao
 *
 * @author xzwnp
 * 2021/10/17
 * 16:09
 * @Description ：
 * Steps：
 */
public interface IStudentDao extends IBaseDao<Student> {
    boolean Login(String name,String password);
}
