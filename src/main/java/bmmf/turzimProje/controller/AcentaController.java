package bmmf.turzimProje.controller;

import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Staff;
import bmmf.turzimProje.model.dto.GeneralResponse;
import bmmf.turzimProje.service.StaffService;
import bmmf.turzimProje.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/acenta")
public class AcentaController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public ModelAndView dashboard(HttpSession httpSession){
        AcentaUser acentaUser = (AcentaUser) httpSession.getAttribute(Constants.userInfoKey);
        ModelAndView modelAndView = new ModelAndView("acenta/dashboard");
        modelAndView.addObject("staffs",staffService.findAllStaff(acentaUser));
        return modelAndView;
    }

    @PostMapping("createStaff")
    @ResponseBody
    public GeneralResponse createStaff(@RequestBody Staff staff, HttpSession httpSession){
        AcentaUser acentaUser = (AcentaUser) httpSession.getAttribute(Constants.userInfoKey);
        return staffService.save(staff, acentaUser);
    }
}
