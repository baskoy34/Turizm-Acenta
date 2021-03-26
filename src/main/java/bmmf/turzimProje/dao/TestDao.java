package bmmf.turzimProje.dao;

import bmmf.turzimProje.model.Test;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class TestDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Test> findAll(){
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select * from Test");
        sqlQuery.addEntity(Test.class);
        return sqlQuery.list();
    }

    public Test save(Test test){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("insert into Test(name) values(:val1) ");
        query.setParameter("val1",test.getName());
        query.executeUpdate();
        BigInteger result = (BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()")
                .uniqueResult();
        test.setId(result.intValue());
        return test;
    }
}
