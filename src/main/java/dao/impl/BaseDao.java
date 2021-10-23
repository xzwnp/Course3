package dao.impl;

import dao.IBaseDao;
import uitl.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.registry.infomodel.User;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.io.Serializable;
/**
 * dao.impl
 *
 * @author xzwnp
 * 2021/10/17
 * 15:21
 * @Description ：
 * Steps：
 */

public class BaseDao<T> implements IBaseDao<T> {

    private Class<T> clz;

    public BaseDao() {
        ParameterizedType parametclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parametclass.getActualTypeArguments();
        clz = (Class<T>) actualTypeArguments[0];
    }

    @Override
    public void save(T s) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void update(T s) {
        EntityManager manager = JPAUtil.getEntityManager();
        //原子性：放在begin和commit之间的语句，要么所有语句一起成功，要么一起失败
        manager.getTransaction().begin();
        //merge：合并，新的信息和老的信息合并，即更新
        manager.merge(s);
        manager.getTransaction().commit();
        manager.close();
    }
    @Override
    public void delete(Serializable Id) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        T s = manager.find(clz, Id);
        manager.remove(s);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public T getOne(Serializable Id) {
        EntityManager manager = JPAUtil.getEntityManager();
        T s = manager.find(clz, Id);
        manager.close();
        return s;
    }

    @Override
    public List getAll() {
        EntityManager manager = JPAUtil.getEntityManager();
        String sql = "select p from "+ clz.getName() +" as p";
        //String sql = "select p from User as p";
        Query query = manager.createQuery(sql);
        return query.getResultList();
    }



}
