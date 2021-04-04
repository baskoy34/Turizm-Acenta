package bmmf.turzimProje.dao;

import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Users;
import bmmf.turzimProje.model.dto.CreateUserDto;
import bmmf.turzimProje.model.dto.GeneralResponse;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

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

    public void createAcenteUser(CreateUserDto userDto){
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("INSERT INTO users(password, userType, username) values (:password, :userType, :username)");
        sqlQuery.setParameter("password", userDto.getPassword());
        sqlQuery.setParameter("userType", userDto.getUserType().getDescription());
        sqlQuery.setParameter("username", userDto.getUsername());
        sqlQuery.executeUpdate();

        BigInteger result = (BigInteger) session.createSQLQuery("SELECT mytable_seq.nextval MyTableID FROM DUAL()")
                .uniqueResult();
        int userID = result.intValue();

        SQLQuery sqlQuery2 = session.createSQLQuery("INSERT INTO acentauser(acentaName, UserID) values (:acentaName, :userId)");
        sqlQuery2.setParameter("acentaName", userDto.getAcentaName());
        sqlQuery2.setParameter("userId",userID);
        sqlQuery2.executeUpdate();
    }
}
