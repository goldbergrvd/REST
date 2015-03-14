package haha.controller;

import haha.bean.ProgramLanguage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/pglang")
public class ProgramLanguageController {

    /**
     * test body:
     *   {"name":"Java","communityIndex":2,"rating":0.1558,"type":"Object oriented"}
     */
    @RequestMapping(value = "/postBean", method = POST)
    public String testPostBean(@RequestBody ProgramLanguage programLanguage) {
        System.out.println(programLanguage.getName() + " - " +
                           programLanguage.getCommunityIndex() + " - " +
                           programLanguage.getRating() + " - " +
                           programLanguage.getType() + " - " +
                           programLanguage.isInterpret());
        return "testBean success!!";
    }

    /**
     * test body:
     *   [{"name":"Java","communityIndex":2,"rating":0.1558,"type":"Object oriented","interpret":false},{"name":"JavaScript","communityIndex":7,"rating":0.0362,"type":"Object oriented, Prototype","interpret":true},{"name":"Python","communityIndex":8,"rating":0.0261,"type":"Object oriented, Functional","interpret":true}]
     */
    @RequestMapping(value = "/postBeanList", method = POST)
    public String testPostBeanList(@RequestBody List<ProgramLanguage> programLanguages) {
        System.out.println("----------program language list----------");
        for (ProgramLanguage programLanguage : programLanguages) {
            System.out.println(programLanguage.getName() + " - " +
                                programLanguage.getCommunityIndex() + " - " +
                                programLanguage.getRating() + " - " +
                                programLanguage.getType() + " - " +
                                programLanguage.isInterpret());
        }
        return "testList success!!";
    }

    @RequestMapping(value = "/getBean", method = GET)
    public ProgramLanguage testGetBean() {
        ProgramLanguage programLanguage = new ProgramLanguage();
        programLanguage.setName("Python");
        programLanguage.setCommunityIndex(8);
        programLanguage.setRating(0.0026);
        programLanguage.setType("Object oriented & Functional");
        programLanguage.setInterpret(true);

        return programLanguage;
    }


    @RequestMapping(value = "/getBeanList", method = GET)
    public List<ProgramLanguage> testGetBeanList() {
        List<ProgramLanguage> programLanguages = new ArrayList<ProgramLanguage>();

        ProgramLanguage programLanguage1 = new ProgramLanguage();
        programLanguage1.setName("Java");
        programLanguage1.setCommunityIndex(2);
        programLanguage1.setRating(0.1664);
        programLanguage1.setType("Object oriented & Command");
        programLanguage1.setInterpret(false);

        ProgramLanguage programLanguage2 = new ProgramLanguage();
        programLanguage2.setName("Python");
        programLanguage2.setCommunityIndex(8);
        programLanguage2.setRating(0.0026);
        programLanguage2.setType("Object oriented & Functional");
        programLanguage2.setInterpret(true);

        ProgramLanguage programLanguage3 = new ProgramLanguage();
        programLanguage3.setName("JavaScript");
        programLanguage3.setCommunityIndex(7);
        programLanguage3.setRating(0.0362);
        programLanguage3.setType("Object oriented & Prototype");
        programLanguage3.setInterpret(true);

        programLanguages.add(programLanguage1);
        programLanguages.add(programLanguage2);
        programLanguages.add(programLanguage3);

        return programLanguages;
    }

    @RequestMapping(value = "/getBeanMap", method = GET)
    public Map<String, ProgramLanguage> testGetBeanMap() {
        Map<String, ProgramLanguage> programLanguages = new HashMap<String, ProgramLanguage>();

        ProgramLanguage programLanguage1 = new ProgramLanguage();
        programLanguage1.setName("Java");
        programLanguage1.setCommunityIndex(2);
        programLanguage1.setRating(0.1664);
        programLanguage1.setType("Object oriented & Command");
        programLanguage1.setInterpret(false);

        ProgramLanguage programLanguage2 = new ProgramLanguage();
        programLanguage2.setName("Python");
        programLanguage2.setCommunityIndex(8);
        programLanguage2.setRating(0.0026);
        programLanguage2.setType("Object oriented & Functional");
        programLanguage2.setInterpret(true);

        ProgramLanguage programLanguage3 = new ProgramLanguage();
        programLanguage3.setName("JavaScript");
        programLanguage3.setCommunityIndex(7);
        programLanguage3.setRating(0.0362);
        programLanguage3.setType("Object oriented & Prototype");
        programLanguage3.setInterpret(true);

        programLanguages.put(programLanguage1.getName(), programLanguage1);
        programLanguages.put(programLanguage2.getName(), programLanguage2);
        programLanguages.put(programLanguage3.getName(), programLanguage3);

        return programLanguages;
    }
}

