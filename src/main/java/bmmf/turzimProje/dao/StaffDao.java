package bmmf.turzimProje.dao;

import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Staff;
import bmmf.turzimProje.model.Users;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Staff> findAllStuff(AcentaUser acentaUser){
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select * from staff where acenta_ID=:id");
        sqlQuery.setParameter("id",acentaUser.getId());
        sqlQuery.addEntity(Staff.class);
        return sqlQuery.list();
    }

    public void insert(Staff staff, AcentaUser acentaUser){
        String query = "insert into staff(firstname, job, lastname, price, acenta_ID) values(:firstname, :job, :lastname, :price,  :acentaId)";
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(query);
        sqlQuery.setParameter("firstname",staff.getFirstName());
        sqlQuery.setParameter("job",staff.getJob());
        sqlQuery.setParameter("lastname",staff.getLastName());
        sqlQuery.setParameter("price",staff.getPrice());
        sqlQuery.setParameter("acentaId",acentaUser.getId());
        sqlQuery.executeUpdate();
    }
}