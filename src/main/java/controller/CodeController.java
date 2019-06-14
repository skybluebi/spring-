package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class CodeController {
    @RequestMapping("/proCode")
    public void proCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);
        response.setContentType("image/jpeg");
        Map<String, Object> map = CodeUtil.generateCodeAndPic();
        request.getSession().setAttribute("code", map.get("code"));
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write((RenderedImage) map.get("codePic"),"jpeg" ,outputStream );
    }
}
