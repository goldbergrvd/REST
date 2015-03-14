package haha.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import haha.bean.Car;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/haha")
public class HahaController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/send", method = POST)
    public String getGreeting(@RequestBody Car car) {
        System.out.println(car.getId() + " - " + car.getData());
        return "RECEIVED!";
    }

    @RequestMapping(value = "/date/{date}", method = GET)
    public Date testDate(@PathVariable @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date date) {
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(date));
        return date;
    }

//    @RequestMapping(value = "/datetime/{datetime}", method = GET)
//    public Date testDatetime(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") Date datetime) {
//        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(datetime));
//        return datetime;
//    }

    @RequestMapping(value = "/datetime", method = GET)
    public Date testDatetime(@RequestParam(value="date") @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss.SSS") Date datetime) {
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(datetime));
        return datetime;
    }

    @RequestMapping(value = "/showServletRequest", method = GET)
    public String showServletReqeust() {
        String result = "RequestURL: " + request.getRequestURI() + "\n";
        result += "ContextPath: " + request.getContextPath() + "\n";
        result += "ServletPath: " + request.getServletPath() + "\n";
        result += "PathInfo: " + request.getPathInfo() + "\n";
        result += "PathTranslated: " + request.getPathTranslated() + "\n";
        return result;
    }

}

