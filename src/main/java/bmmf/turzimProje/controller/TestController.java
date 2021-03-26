package bmmf.turzimProje.controller;

import bmmf.turzimProje.model.Test;
import bmmf.turzimProje.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test")
    @ResponseBody
    public List<Test> findAll() {

        return testService.findAll();
    }
    @PostMapping("test")
    @ResponseBody
    public Test add(@RequestBody Test test){
        return testService.save(test);
    }
}
