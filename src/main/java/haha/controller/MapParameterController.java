package haha.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/map")
public class MapParameterController {

    @RequestMapping(method = RequestMethod.POST)
    public String map(@RequestParam Map<String, String> param) {
        for (String key : param.keySet()) {
            System.out.println(key + ": " + param.get(key));
        }
        return "Success!";
    }

}
