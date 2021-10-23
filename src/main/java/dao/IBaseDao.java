package dao;

import javax.xml.registry.infomodel.User;
import java.io.Serializable;
import java.util.List;

/**
 * dao
 *
 * @author xzwnp
 * 2021/10/17
 * 15:07
 * @Description ：
 * Steps：
 */
public interface IBaseDao<T> {
    void save(T s);
    void update(T s);
    void delete(Serializable Id);
    T getOne(Serializable Id);
    List<T> getAll();

}
