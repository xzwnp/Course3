import dao.impl.UserDao;
import org.junit.Test;

import java.util.List;
import entity.User;
/**
 * PACKAGE_NAME
 *
 * @author xzwnp
 * 2021/10/17
 * 16:12
 * @Description ：
 * Steps：
 */
public class UserDaoTest {
    UserDao userDao = new UserDao();
    @Test
    public void testCreateUser(){
        User user = new User();
        user.setId(1L);
        user.setUserName("小明");
        user.setPassword("123456");
        user.setAge(20);
        user.setSex(true);
        userDao.save(user);
    }
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(2L);
        user.setUserName("小白");
        user.setPassword("123456");
        user.setAge(20);
        user.setSex(true);
        userDao.update(user);
    }
    @Test
    public void testDeleteUser(){
        userDao.delete(2L);
    }
    @Test
    public void testGetOne(){
        userDao.delete(2L);
    }
    @Test
    public void testGetAll(){
        List<User> list = userDao.getAll();

        list.forEach(stu-> System.out.println(stu.getUserName()));
    }
    @Test
    public void testLogin(){
        System.out.println(userDao.login("小明","123456"));
    }
}

