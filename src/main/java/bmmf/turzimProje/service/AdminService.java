package bmmf.turzimProje.service;

import bmmf.turzimProje.dao.AdminDao;
import bmmf.turzimProje.model.Admins;
import bmmf.turzimProje.model.Users;
import bmmf.turzimProje.model.dto.CreateUserDto;
import bmmf.turzimProje.model.dto.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private UserService userService;

    @Autowired
    private AcentaUserService acentaService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Admins findByUser(Users user) {
        return adminDao.findByUser(user);
    }

    public GeneralResponse createAcentaUser(CreateUserDto userDto) {
        Users user = userService.findByUserName(userDto.getUsername());
        if (nonNull(user)) {
            return GeneralResponse
                    .builder()
                    .message("Kullanıcı ismi Kullanılıyor.")
                    .result(1)
                    .build();
        }
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        GeneralResponse response = acentaService.createAcenteUser(userDto);
        return response;
    }

    public List<Users> listAcentaUser() {
        return adminDao.listUsers();
    }

    public Users getUser(Long theId) {
        return adminDao.getUser(theId);
    }
}
