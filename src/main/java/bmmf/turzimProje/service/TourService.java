package bmmf.turzimProje.service;

import bmmf.turzimProje.dao.TourDao;
import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Staff;
import bmmf.turzimProje.model.Tour;
import bmmf.turzimProje.model.dto.GeneralResponse;
import bmmf.turzimProje.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



@Service
@Transactional
public class TourService {

    @Autowired
    private TourDao tourDao;

    public GeneralResponse save(Tour tour, AcentaUser acentaUser){
        GeneralResponse response = GeneralResponse.builder().build();
        try{
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate = LocalDate.from(f.parse(tour.getStartDate()));
            LocalDate endDate = LocalDate.from(f.parse(tour.getEndDate()));
            if (startDate.isAfter(endDate)){
                response.setMessage("Başlangıç tarihi, bitiş tarihinden büyük");
                response.setResult(1);
                return response;
            }
        }catch (Exception e){
            response.setResult(1);
            response.setMessage("Tarih giriniz");
            return response;


        }

        try {
            tourDao.insert(tour, acentaUser);
            response.setResult(0);
            response.setMessage(Constants.success);
        } catch (Exception e){
            response.setResult(1);
            response.setMessage(Constants.err);
        }
        return response;
    }

}
