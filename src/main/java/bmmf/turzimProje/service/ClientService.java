package bmmf.turzimProje.service;

import bmmf.turzimProje.dao.ClientDao;
import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Client;
import bmmf.turzimProje.model.dto.GeneralResponse;
import bmmf.turzimProje.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    public List<Client> findAllClient(){
        return clientDao.findAllClient();
    }


    public List<Client> findTourClient(Long id) {
        return clientDao.findTourClient(id);
    }


    public GeneralResponse save(Client client) {
        GeneralResponse generalResponse = GeneralResponse.builder().build();
        try{
            clientDao.insert(client);
            generalResponse.setResult(0);
            generalResponse.setMessage(Constants.success);
        }catch (Exception e){
            generalResponse.setResult(1);
            generalResponse.setMessage(Constants.err);
        }
        return generalResponse;
    }

    public GeneralResponse delete(Long id) {
        GeneralResponse generalResponse = GeneralResponse.builder().build();
        try {
            clientDao.delete(id);
            generalResponse.setResult(0);
            generalResponse.setMessage(Constants.success);
        }catch (Exception e){
            generalResponse.setResult(1);
            generalResponse.setMessage(Constants.err);
        }
        return generalResponse;
    }

    public GeneralResponse update(Client client) {
        GeneralResponse generalResponse = GeneralResponse.builder().build();
        try{
            clientDao.update(client);
            generalResponse.setResult(0);
            generalResponse.setMessage(Constants.success);
        }catch (Exception e){
            generalResponse.setResult(1);
            generalResponse.setMessage(Constants.err);
        }
        return generalResponse;
    }

}
