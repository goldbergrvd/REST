package haha.controller;

import haha.bean.Car;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/heyhey")
public class HeyHeyController {

    @RequestMapping(value="/get", method=GET)
    public List<Car> getCars() {
        List<Car> result=new ArrayList<Car>();
        result.add(new Car(1, "NeoTridaggerZMC"));
        result.add(new Car(2, "BeakSpider"));
        result.add(new Car(3, "Jaguar"));
        return result;
    }

    @RequestMapping(value="/singlejson", method=POST)
    public String receiveCar(@Valid @RequestBody Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println(error.getField() + " - " + error.getDefaultMessage());
            }
            return "Errors!";
        }

        System.out.println(car.getId() + " - " + car.getData());
        return "Oh @RequestBody singlejson yes!";
    }

    @RequestMapping(value="/multijson", method=POST)
    public String receiveCar(@RequestBody List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getId() + " - " + car.getData());
        }
        return "Oh @RequestBody multijson yes!";
    }

    @RequestMapping(value="/param", method=POST)
    public String bitch(@RequestParam(value="name", defaultValue="This is default!") String name) {
        System.out.println(name);
        return "Oh @RequestParam yes!";
    }

//    @RequestMapping(value="/map", method=POST)
//    public String map(@MatrixVariable Map<String, String> map) {
//        System.out.println(map.get("id") + " - " + map.get("data"));
//        return "Oh @MatrixVariable yes!";
//    }

    @RequestMapping(value="/header", method=POST)
    public String header(@RequestHeader Map<String, String> map) {
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        return "Oh @RequestHeader yes!";
    }

    @RequestMapping(value="/multipart", method=POST)
    public String header(@RequestPart(value="car") Car car) {
        System.out.println(car.getId() + " - " + car.getData());
        return "Oh @RequestPart yes!";
    }

}
