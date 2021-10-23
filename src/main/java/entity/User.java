package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * entity
 *
 * @author xzwnp
 * 2021/10/17
 * 15:42
 * @Description ：
 * Steps：
 */
@Entity
public class User{
    @Id
    private Long id;
    private String userName;
    private String password;
    private boolean sex;
    private int age;
    private float height;

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}