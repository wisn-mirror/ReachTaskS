package com.wisn.web;


import com.sun.jmx.snmp.Timestamp;
import com.wisn.http.bean.DownloadRecord;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/resource")
public class UserResourceController {

    private static final String TAG = "UserResourceController";

    @RequestMapping(value = "/icon", method = RequestMethod.GET)
    public void getResource( HttpServletRequest request,
                             HttpServletResponse response,
                             String path) {
        String basePath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("path:"+path);
//声明本次下载状态的记录对象
        DownloadRecord downloadRecord = new DownloadRecord("resource", path, request);
        //设置响应头和客户端保存文件名

        //用于记录以完成的下载的数据量，单位是byte
        long downloadedLength = 0l;
        try {
            File file=new File(basePath+path);
            if(file.exists()){
                response.setCharacterEncoding("utf-8");
                response.setContentType("multipart/form-data");
                response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
                //打开本地文件流
                InputStream inputStream = new FileInputStream(file);
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
            }
        } catch (Exception e){
            downloadRecord.setStatus(DownloadRecord.STATUS_ERROR);
        }
        downloadRecord.setStatus(DownloadRecord.STATUS_SUCCESS);
        downloadRecord.setEndTime(new Timestamp(System.currentTimeMillis()));
        downloadRecord.setLength(downloadedLength);
    }

    /**
     * 文件下载的简单方式 ，不适用大文件的下载
     * @param request
     * @param response
     * @param path
     * @return
     * @throws IOException
     */
    @RequestMapping("/icon2")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           HttpServletResponse response,
                                           String path) throws IOException {
        String basePath = request.getSession().getServletContext().getRealPath("/");
        File file = new File(basePath+path);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }

}
