package bmmf.turzimProje.controller;

import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Admins;
import bmmf.turzimProje.model.Users;
import bmmf.turzimProje.model.dto.CreateUserDto;
import bmmf.turzimProje.model.dto.GeneralResponse;
import bmmf.turzimProje.model.enums.UserType;
import bmmf.turzimProje.service.AdminService;
import bmmf.turzimProje.utils.Constants;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView index(HttpSession httpSession){
        Admins admin = (Admins) httpSession.getAttribute(Constants.userInfoKey);
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/createUser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getCreateUser(@RequestParam(value = "userId", required = false) Long theId, HttpSession httpSession){

        ModelAndView modelAndView = new ModelAndView("createUser");
        List<UserType> userTypes = Arrays.asList(UserType.values());
        modelAndView.addObject("userRoles",userTypes);
        modelAndView.addObject("users", new Users());

        if (theId != null){
            Users users = adminService.getUser(theId);
            modelAndView.addObject("users", users);
        }

        return modelAndView;
    }

    @PostMapping("/createUser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public GeneralResponse postCreateUser(@RequestBody CreateUserDto userDto, HttpSession httpSession){
        GeneralResponse response = adminService.createAcentaUser(userDto);
        return response;
    }

    @GetMapping("/listUser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public ModelAndView getUserList(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("listUsers");
        List<Users> users = adminService.listAcentaUser();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

}
