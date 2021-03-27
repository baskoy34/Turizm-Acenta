package bmmf.turzimProje.dao;

import bmmf.turzimProje.model.Users;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Users findByUserName(String userName){
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select * from users where username=:name");
        sqlQuery.setParameter("name", userName);
        sqlQuery.addEntity(Users.class);
        return (Users) sqlQuery.getSingleResult();
    }
}
