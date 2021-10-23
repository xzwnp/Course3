package dao.impl;

import entity.Student;
import entity.User;
import uitl.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * dao.impl
 *
 * @author xzwnp
 * 2021/10/17
 * 15:59
 * @Description ：
 * Steps：
 */
public class UserDao extends BaseDao<User> {
    public boolean login(String userName, String password) {
        EntityManager manager = JPAUtil.getEntityManager();
        String sql = "select u from User u where u.userName = :userName and u.password =:password  ";
        Query query = manager.createQuery(sql);
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        List list = query.getResultList();
        manager.close();
        return list.size() >= 1;
    }

}
