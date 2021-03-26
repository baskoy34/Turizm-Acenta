package bmmf.turzimProje.service;

import bmmf.turzimProje.dao.TestDao;
import bmmf.turzimProje.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TestService {

    @Autowired
    private TestDao testDao;

    public List<Test> findAll(){
        List<Test> tests = testDao.findAll();
        return tests;
    }

    public Test save(Test test){
        return testDao.save(test);
    }
}
