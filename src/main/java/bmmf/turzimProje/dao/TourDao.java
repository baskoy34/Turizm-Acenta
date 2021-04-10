package bmmf.turzimProje.dao;

import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Client;
import bmmf.turzimProje.model.Tour;
import bmmf.turzimProje.model.Users;
import bmmf.turzimProje.model.dto.GeneralResponse;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Tour> findByAll(){

        return null;
    }

    public void insert (Tour tour,AcentaUser acentaUser){
        String query = "insert into tour(price, startDate, endDate, location,capasity, details,acenta_tour,tourtype) values(:price, :startDate, :endDate, :location,:capasity,  :details,:acentaId,:tourType)";
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(query);
        sqlQuery.setParameter("price",tour.getPrice());
        sqlQuery.setParameter("startDate",tour.getStartDate());
        sqlQuery.setParameter("endDate",tour.getEndDate());
        sqlQuery.setParameter("location",tour.getLocation());
        sqlQuery.setParameter("capasity",tour.getCapasity());

        sqlQuery.setParameter("details",tour.getDetails());
        sqlQuery.setParameter("acentaId",acentaUser.getId());
        sqlQuery.setParameter("tourType",tour.getTourType().getName());

        sqlQuery.executeUpdate();



    }


}
