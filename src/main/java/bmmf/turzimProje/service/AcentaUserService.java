package bmmf.turzimProje.service;

import bmmf.turzimProje.dao.AcentaUserDao;
import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Users;
import bmmf.turzimProje.model.dto.CreateUserDto;
import bmmf.turzimProje.model.dto.GeneralResponse;
import bmmf.turzimProje.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class AcentaUserService {

    @Autowired
    private AcentaUserDao acentaUserDao;

    public AcentaUser findByUser(Users user) {
        return acentaUserDao.findByUser(user);
    }

    public GeneralResponse createAcenteUser(CreateUserDto userDto) {
        GeneralResponse response = GeneralResponse.builder().build();
        try {
            acentaUserDao.createAcenteUser(userDto);
            response.setMessage(Constants.success);
            response.setResult(0);
        } catch (Exception ex) {
            log.error("acenta user olustururken hata : {}",ex);
            response.setMessage(Constants.err);
            response.setResult(1);
        }
        return response;
    }
}
