package com.wisn.web;


import com.sun.jmx.snmp.Timestamp;
import com.wisn.entity.Moment;
import com.wisn.entity.Resource;
import com.wisn.exception.NoAuthException;
import com.wisn.exception.ParameterException;
import com.wisn.http.HttpResponse;
import com.wisn.http.bean.DownloadRecord;
import com.wisn.protocol.session.TokenEntity;
import com.wisn.protocol.session.TokenManager;
import com.wisn.service.MomentService;
import com.wisn.service.ResourceService;
import com.wisn.tools.FSUtils;
import com.wisn.tools.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/resource")
public class UserResourceController {

    private static final String TAG = "UserMomentController";

    @RequestMapping(value = "/icon", method = RequestMethod.GET)
    public void getResource( HttpServletRequest request,
                             HttpServletResponse response,
                             String path) {
        String basePath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("path:"+path);
//声明本次下载状态的记录对象
        DownloadRecord downloadRecord = new DownloadRecord("resource", path, request);
        //设置响应头和客户端保存文件名
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + path);
        //用于记录以完成的下载的数据量，单位是byte
        long downloadedLength = 0l;
        try {
            //打开本地文件流
            InputStream inputStream = new FileInputStream(basePath+path);
            //激活下载操作
            OutputStream os = response.getOutputStream();

            //循环写入输出流
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
                downloadedLength += b.length;
            }

            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (Exception e){
            downloadRecord.setStatus(DownloadRecord.STATUS_ERROR);
        }
        downloadRecord.setStatus(DownloadRecord.STATUS_SUCCESS);
        downloadRecord.setEndTime(new Timestamp(System.currentTimeMillis()));
        downloadRecord.setLength(downloadedLength);
    }

}
