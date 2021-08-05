package com.itjizhiyong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


public class FaceController {

//    @RequestMapping("/FaceID")
//    public void xx(HttpServletRequest request, HttpServletResponse response,
//                   @RequestParam("id") String id){
//        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
//        MultipartFile file = multipartRequest.getFile("image");
//        String filePath =request.getSession().getServletContext().getRealPath("/Face_Resource/FaceID.jpeg");
//        try {
//            file.transferTo(new File(filePath));
//            String filePath2=request.getSession().getServletContext().getRealPath("/Face_Resource/"+id+".jpeg");
//            double d=faceId.FaceId(filePath, filePath2);
//            if(d>=80){
//                response.getWriter().print("success");
//            }else {
//                response.getWriter().print("error");
//            }
//        } catch (IllegalStateException e) {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        }
    }
