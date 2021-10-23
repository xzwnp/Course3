package uitl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    public static EntityManagerFactory factory;
    static {
        //persistenceUitlName与persistence.xml的<persistence-unit name="default">相对应
        factory = Persistence.createEntityManagerFactory("default");
    }
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}