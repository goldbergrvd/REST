package haha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/upload", method = POST)
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        File newfile = new File(getThisWebappWebInfPath(), file.getOriginalFilename());
        System.out.println(newfile.getAbsolutePath());
        try {
            InputStream is = file.getInputStream();
            OutputStream os = new FileOutputStream(newfile);

            int read = -1;
            while ((read = is.read()) != -1) {
                os.write(read);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "upload file fail!";
        }
        return "upload file success!";
    }

    @RequestMapping(value = "/download", method = POST)
    public void downloadFile(HttpServletResponse response, @RequestParam(value = "filename") String filename) throws IOException {
        File downloadFile = new File(getThisWebappWebInfPath(), filename);

        String mimeType = "octect/stream";
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=\"%s\"" + downloadFile.getName();

        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        response.setHeader(headerKey, headerValue);

        FileInputStream is = new FileInputStream(downloadFile);
        OutputStream os = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        // write bytes read from the input stream into the output stream
        while ((bytesRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }

        is.close();
        os.close();
    }

    private String getThisWebappWebInfPath() {
        String contextPath = request.getContextPath();
        String pathTranslated = request.getPathTranslated();
        int endIndex = pathTranslated.indexOf(contextPath) + contextPath.length();
        String webappRootPath = pathTranslated.substring(0, endIndex) + "/WEB-INF";
        System.out.println(webappRootPath);
        return webappRootPath;
    }

}
