package bmmf.turzimProje.controller;

import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.model.Client;
import bmmf.turzimProje.model.Staff;
import bmmf.turzimProje.model.dto.GeneralResponse;
import bmmf.turzimProje.model.dto.TourDto;
import bmmf.turzimProje.model.enums.TourType;
import bmmf.turzimProje.service.ClientService;
import bmmf.turzimProje.service.StaffService;
import bmmf.turzimProje.service.TourService;
import bmmf.turzimProje.utils.Constants;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/acenta")
public class AcentaController {

    @Autowired
    private StaffService staffService;
    @Autowired
    private TourService tourService;
    @Autowired
    private ClientService clientService;

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
    @ResponseBody
    public GeneralResponse createTour(@RequestBody TourDto tourDto, HttpSession httpSession){
        AcentaUser acentaUser = (AcentaUser) httpSession.getAttribute(Constants.userInfoKey);
        return tourService.save(tourDto,acentaUser);

    }


    @GetMapping("getTour")
    public ModelAndView getTour(HttpSession httpSession){
        AcentaUser acentaUser = (AcentaUser) httpSession.getAttribute(Constants.userInfoKey);
        ModelAndView view =new ModelAndView("acenta/createTour");
        view.addObject("staffs",staffService.findAllStaff(acentaUser));
        view.addObject("tourTypes", TourType.values());

        return view;
    }

    @GetMapping("tours")
    public ModelAndView getTours(HttpSession httpSession){
        AcentaUser acentaUser = (AcentaUser) httpSession.getAttribute(Constants.userInfoKey);
        ModelAndView view =new ModelAndView("acenta/tours");
//        view.addObject("staffs",staffService.findAllStaff(acentaUser));
        return view;
    }

    @GetMapping("getTours")
    @ResponseBody
    public List<TourDto> findTours(@ModelAttribute TourDto tourDto, HttpSession httpSession)throws Exception{
        AcentaUser acentaUser = (AcentaUser) httpSession.getAttribute(Constants.userInfoKey);
        tourDto.setAcenta_Id(acentaUser.getId());
        return tourService.findByTour(tourDto);
    }

    @GetMapping("/client")
    public ModelAndView dashboardClient(){
        ModelAndView modelAndView = new ModelAndView("client/dashboard");
        modelAndView.addObject("clients",clientService.findAllClient());
        return modelAndView;
    }

    @PostMapping("/client")
    @ResponseBody
    public GeneralResponse createClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @DeleteMapping("/client")
    @ResponseBody
    public GeneralResponse deleteClient(@RequestParam("id") Long id){
        return clientService.delete(id);
    }

    @PutMapping("/client")
    @ResponseBody
    public GeneralResponse updateClient(@RequestBody Client client){
        return clientService.update(client);
    }

}
