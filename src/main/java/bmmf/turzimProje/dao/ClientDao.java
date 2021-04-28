package bmmf.turzimProje.dao;

import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Client;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Client> findAllClient(){
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select * from client");
        sqlQuery.addEntity(Client.class);
        return sqlQuery.list();
    }

    public List<Client> findTourClient(Long id) {
        String query = "select * from client c INNER JOIN sales s on s.tour_id=c.id where s.tour_id=:tour_id";
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(query);
        sqlQuery.setParameter("tour_id", id);
        sqlQuery.addEntity(Client.class);
        return sqlQuery.list();
    }

    public void insert(Client client) {
        String query = "insert into client(address, email, name, phone, surname) values(:address, :email, :name, :phone, :surname)";
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(query);
        sqlQuery.setParameter("address", client.getAddress());
        sqlQuery.setParameter("email", client.getEmail());
        sqlQuery.setParameter("name", client.getName());
        sqlQuery.setParameter("phone", client.getPhone());
        sqlQuery.setParameter("surname", client.getSurname());
        sqlQuery.setParameter("address", client.getAddress());
        sqlQuery.executeUpdate();
    }

    public void delete(Long id) {
        String query = "delete from client where id=:id";
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(query);
        sqlQuery.setParameter("id", id);
        sqlQuery.executeUpdate();
    }

    public void update(Client client) {
        String query = "update client set name=:name, surname=:surname, email=:email, phone=:phone, address=:address where id=:id";
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(query);
        sqlQuery.setParameter("address", client.getAddress());
        sqlQuery.setParameter("email", client.getEmail());
        sqlQuery.setParameter("name", client.getName());
        sqlQuery.setParameter("phone", client.getPhone());
        sqlQuery.setParameter("surname", client.getSurname());
        sqlQuery.setParameter("address", client.getAddress());
        sqlQuery.setParameter("id", client.getId());
        sqlQuery.executeUpdate();
    }

}
