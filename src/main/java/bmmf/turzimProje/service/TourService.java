package bmmf.turzimProje.service;

import bmmf.turzimProje.dao.PersonelTourDao;
import bmmf.turzimProje.dao.TourDao;
import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Staff;
import bmmf.turzimProje.model.Tour;
import bmmf.turzimProje.model.dto.GeneralResponse;
import bmmf.turzimProje.model.dto.TourDto;
import bmmf.turzimProje.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class TourService {

    @Autowired
    private TourDao tourDao;

    @Autowired
    private PersonelTourDao personelTourDao;

    public GeneralResponse save(TourDto tourDto, AcentaUser acentaUser){
        GeneralResponse response = GeneralResponse.builder().build();
        try{
            if(StringUtils.isEmpty(tourDto.getStartDate())){
                response.setResult(1);
                response.setMessage("Başlangıc Tarihi giriniz");
            }
            if(StringUtils.isEmpty(tourDto.getEndDate())){
                response.setResult(1);
                response.setMessage("Bitiş Tarihi giriniz");
            }
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate = LocalDate.from(f.parse(tourDto.getStartDate()));
            LocalDate endDate = LocalDate.from(f.parse(tourDto.getEndDate()));
            if (startDate.isAfter(endDate)){
                response.setMessage("Başlangıç tarihi, bitiş tarihinden büyük");
                response.setResult(1);
                return response;
            }
        }catch (Exception e){
            response.setResult(1);
            response.setMessage("Girdiğiniz Tarih Hatalı");
            return response;
        }
        try {
            long tId = tourDao.insert(tourDto, acentaUser);
            tourDto.getPersonels().forEach(id -> personelTourDao.save(tId,id));
            response.setResult(0);
            response.setMessage(Constants.success);
        } catch (Exception e){
            response.setResult(1);
            response.setMessage(Constants.err);
        }
        return response;
    }

    public List<TourDto> findByTour(TourDto tourDto){
        List<Tour> tours = tourDao.findByTour(tourDto);
        return tours.stream().map(tour ->
                TourDto.builder()
                        .id(tour.getId())
                        .capacity(tour.getCapasity())
                        .description(tour.getDetails())
                        .endDate(tour.getEndDate())
                        .startDate(tour.getStartDate())
                        .location(tour.getLocation())
                        .price(tour.getPrice())
                        .tourType(tour.getTourType())
                        .build()
        ).collect(Collectors.toList());
    }
}
