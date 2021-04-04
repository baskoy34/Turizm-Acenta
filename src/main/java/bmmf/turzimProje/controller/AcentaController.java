package bmmf.turzimProje.controller;

import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Staff;
import bmmf.turzimProje.model.Tour;
import bmmf.turzimProje.model.dto.GeneralResponse;
import bmmf.turzimProje.model.enums.TourType;
import bmmf.turzimProje.service.StaffService;
import bmmf.turzimProje.service.TourService;
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
    @Autowired
    private TourService tourService;

    @GetMapping
    public ModelAndView dashboard(HttpSession httpSession){
        AcentaUser acentaUser = (AcentaUser) httpSession.getAttribute(Constants.userInfoKey);
        ModelAndView modelAndView = new ModelAndView("acenta/dashboard");
        modelAndView.addObject("staffs",staffService.findAllStaff(acentaUser));
        return modelAndView;
    }

    @PostMapping("staff")
    @ResponseBody
    public GeneralResponse createStaff(@RequestBody Staff staff, HttpSession httpSession){
        AcentaUser acentaUser = (AcentaUser) httpSession.getAttribute(Constants.userInfoKey);
        return staffService.save(staff, acentaUser);
    }

    @DeleteMapping("staff")
    @ResponseBody
    public GeneralResponse deleteStaff(@RequestParam("id") Long id, HttpSession httpSession){
        AcentaUser acentaUser = (AcentaUser) httpSession.getAttribute(Constants.userInfoKey);
        return staffService.delete(id,acentaUser);
    }

    @PutMapping("staff")
    @ResponseBody
    public GeneralResponse updateStaff(@RequestBody Staff staff, HttpSession httpSession){
        AcentaUser acentaUser = (AcentaUser) httpSession.getAttribute(Constants.userInfoKey);
        return staffService.update(staff, acentaUser);
    }


    @PostMapping("createTour")
    public GeneralResponse createTour(@RequestBody Tour tour,HttpSession httpSession){
        AcentaUser acentaUser = (AcentaUser) httpSession.getAttribute(Constants.userInfoKey);
        return tourService.save(tour,acentaUser);
    }


    @GetMapping("getTour")
    public ModelAndView getTour(HttpSession httpSession){
        AcentaUser acentaUser = (AcentaUser) httpSession.getAttribute(Constants.userInfoKey);
        ModelAndView view =new ModelAndView("/createTour");
        view.addObject("staffs",staffService.findAllStaff(acentaUser));
        view.addObject("tourTypes", TourType.values());

        return view;

    }

}
