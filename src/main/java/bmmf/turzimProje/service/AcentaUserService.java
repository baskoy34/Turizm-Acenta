package bmmf.turzimProje.service;

import bmmf.turzimProje.dao.AcentaUserDao;
import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AcentaUserService {

    @Autowired
    private AcentaUserDao acentaUserDao;

    public AcentaUser findByUser(Users user){
        return acentaUserDao.findByUser(user);
    }
}
