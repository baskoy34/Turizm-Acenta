package bmmf.turzimProje.service;

import bmmf.turzimProje.dao.UserDao;
import bmmf.turzimProje.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public Users findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
}
