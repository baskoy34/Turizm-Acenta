package bmmf.turzimProje.dao;

import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Admins;
import bmmf.turzimProje.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLData;
import java.util.List;

@Repository
@Slf4j
public class AdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Admins findByUser(Users user) {
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select ad.id,ad.adminName,ad.UserID from admin ad  join users u on ad.UserID=u.id where u.id=:userId");
        sqlQuery.setParameter("userId", user.getId());
        sqlQuery.addEntity(Admins.class);
        return (Admins) sqlQuery.getSingleResult();
    }

    public List<Users> listUsers() {
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM users").addEntity(Users.class);
        List<Users> users = sqlQuery.getResultList();
        return users;
    }

    public Users getUser(Long theId) {
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM users where id=:theid").addEntity(Users.class);
        sqlQuery.setParameter("theid", theId);
        Users user = (Users) sqlQuery.getSingleResult();
        return user;
    }
}
