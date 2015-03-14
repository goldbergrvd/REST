package haha.controller;

import haha.bean.Three;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/depth")
public class DepthBeanController {

    /**
     * test body:
     *   {"name":"this is three~","two":{"name":"this is two$","one":{"name":"this is one!","number":100}},"one":{"name":"this is one?","number":101}}
     */
    @RequestMapping(method = POST)
    public String postDepth(@RequestBody Three three) {
        System.out.println(three);
        return "depth test!!";
    }

}
