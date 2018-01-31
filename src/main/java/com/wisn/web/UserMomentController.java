package com.wisn.web;


import com.wisn.entity.Moment;
import com.wisn.entity.Resource;
import com.wisn.entity.User;
import com.wisn.exception.NoAuthException;
import com.wisn.exception.OperationException;
import com.wisn.exception.ParameterException;
import com.wisn.http.HttpResponse;
import com.wisn.protocol.session.TokenEntity;
import com.wisn.protocol.session.TokenManager;
import com.wisn.service.MomentService;
import com.wisn.service.ResourceService;
import com.wisn.tools.FSUtils;
import com.wisn.tools.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/moment")
public class UserMomentController {

    private static final String TAG ="UserMomentController" ;
    @Autowired
    private MomentService momentService;

    @Autowired
    private ResourceService resourceService;

    @ResponseBody
    @RequestMapping(value = "/getments", method = RequestMethod.GET)
    public HttpResponse<List<Moment>> getments(@RequestHeader(value = "Authorization") String Authorization,int offset, int limit) {
        HttpResponse<List<Moment>> response;
        List<Moment> moments = null;
        try {
            TokenEntity tokenEntity = TokenManager.getToken(Authorization);
            if (tokenEntity == null || tokenEntity.getUserid() == 0) {
                throw new NoAuthException("没有登录");
            }
            Long userid = tokenEntity.getUserid();
            System.out.println("userid：：：：：：：：：：："+userid);
             moments= momentService.getMomentAll(userid,offset, limit);
            response = new HttpResponse<>(200, "获取成功");
            response.data = moments;
        } catch (NoAuthException e) {
            response = new HttpResponse<>(403, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response = new HttpResponse<>(500, e.getMessage());
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/sendment", method = RequestMethod.POST)
    public HttpResponse<String> sendment(@RequestHeader(value = "Authorization") String Authorization
            , HttpServletRequest req, String content, String location) {
        HttpResponse<String> stringHttpResponse = null;
        try {
            TokenEntity tokenEntity = TokenManager.getToken(Authorization);
            if (tokenEntity == null || tokenEntity.getUserid() == 0) {
                throw new NoAuthException("没有登录");
            }
            System.out.println("content:" + content + " location:" + location);
            Long userid = tokenEntity.getUserid();
            String basePath = req.getSession().getServletContext().getRealPath("/");

            List<Long> imageres = new ArrayList<>();
            List<Long> videores = new ArrayList<>();
            MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
            Iterator<String> fileNames = mreq.getFileNames();
            while (fileNames.hasNext()) {
                String next = fileNames.next();
                if (next == null) continue;
                System.out.println("name:"+next);
                List<MultipartFile> files = mreq.getFiles(next);
                if (next.equalsIgnoreCase("imageres")) {
                    for (MultipartFile file : files) {
                        System.out.println("file:"+file);
                        Resource resource = saveFile(basePath, file, true);
                        if(resource!=null)
                        imageres.add(resource.getResourceid());
                    }
                } else if (next.equalsIgnoreCase("videores")) {
                    for (MultipartFile file : files) {
                        Resource resource = saveFile(basePath, file, false);
                        if(resource!=null)
                        videores.add(resource.getResourceid());
                    }
                } else {
                    continue;
                }
            }
            Moment moment = new Moment();
            moment.setUserid(userid);
            moment.setCreatetime(System.currentTimeMillis());
            moment.setContent(content);
            moment.setLocation(location);
            moment.setImageres(moment.arrayToString(imageres));
            moment.setVideores(moment.arrayToString(videores));
            momentService.saveMoment(moment);
            stringHttpResponse = new HttpResponse<>(200,  "成功");
        } catch (ParameterException e) {
            e.printStackTrace();
            stringHttpResponse = new HttpResponse<>(400, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            stringHttpResponse = new HttpResponse<>(500, e.getMessage());
        }
        return stringHttpResponse;
    }


    public Resource saveFile(String basePath, MultipartFile file, boolean isImageType) throws Exception {
        String fileName = file.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf('.'));
        if(!isImageType&&!(".jpeg".equalsIgnoreCase(fileType) || ".png".equalsIgnoreCase(fileType) || ".jpg".equalsIgnoreCase(fileType))){
            LogUtils.d(TAG,"image type:"+fileType);
            return null ;
        }else if(!(".mp4".equalsIgnoreCase(fileType))){
            LogUtils.d(TAG,"video type:"+fileType);
//           return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String filename = FSUtils.getUUID();
        String reallyFilename = "files" + File.separator + sdf.format(new Date()) + FSUtils.getHashPath(filename);
        File hashpath = new File(basePath + reallyFilename);
        if (!hashpath.exists()) {
            hashpath.mkdirs();
        }
        String requestFilePath = reallyFilename + filename + fileType;
        FileOutputStream fos = new FileOutputStream(basePath + requestFilePath);
        fos.write(file.getBytes());
        fos.flush();
        fos.close();
        System.out.println("requestFilePath:"+requestFilePath);
        Resource resource = new Resource(1, requestFilePath);
        return resourceService.saveResource(resource);

    }

}
