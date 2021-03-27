package bmmf.turzimProje.controller;

import bmmf.turzimProje.model.AcentaUser;
import bmmf.turzimProje.utils.Constants;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/acenta")
public class IndexController {

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ACENTA')")
    public ModelAndView index(HttpSession session) {
        AcentaUser user = (AcentaUser) session.getAttribute(Constants.userInfoKey);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("test", user.getAcentaName());
        return modelAndView;
    }
}
