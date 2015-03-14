package haha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "springmultipart", method = POST)
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        File newfile = new File(getThisWebappRootPath(), file.getOriginalFilename());
        System.out.println(newfile.getAbsolutePath());
        try {
            InputStream is = file.getInputStream();
            OutputStream os = new FileOutputStream(newfile);
            int i = -1;
            while ((i = is.read()) != -1) {
                os.write(i);
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "upload file fail!";
        }
        return "upload file success!";
    }

    private String getThisWebappRootPath() {
        String contextPath = request.getContextPath();
        String pathTranslated = request.getPathTranslated();
        int endIndex = pathTranslated.indexOf(contextPath) + contextPath.length();
        String webappRootPath = pathTranslated.substring(0, endIndex) + "/WEB-INF";
        System.out.println(webappRootPath);
        return webappRootPath;
    }

}
