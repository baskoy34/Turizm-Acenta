package bmmf.turzimProje.dao;

import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Users;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AcentaUserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public AcentaUser findByUser(Users user) {
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select au.id,au.acentaName,au.UserID from acentauser au  join users u on au.UserID=u.id where u.id=:userId");
        sqlQuery.setParameter("userId", user.getId());
        sqlQuery.addEntity(AcentaUser.class);
        return (AcentaUser) sqlQuery.getSingleResult();
    }
}
