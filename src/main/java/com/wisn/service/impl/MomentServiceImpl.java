package com.wisn.service.impl;

import com.wisn.dao.MomentDao;
import com.wisn.dao.ResourceDao;
import com.wisn.entity.Moment;
import com.wisn.entity.Resource;
import com.wisn.exception.ParameterException;
import com.wisn.service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MomentServiceImpl implements MomentService {

    @Autowired
    MomentDao momentDao;
    @Autowired
    ResourceDao resourceDao;

    @Override
    public int saveMoment(Moment moment) {
        if (moment == null || moment.getUserid() == 0) {
            throw new ParameterException("参数缺少");
        }
        moment.setCreatetime(System.currentTimeMillis());
        int insertMoment = momentDao.insertMoment(moment);
        return insertMoment;
    }

    @Override
    public Moment getMoment(long momentid) {
        if (momentid == 0) {
            throw new ParameterException("参数缺少");
        }
        return momentDao.queryMomentByMomentId(momentid);
    }

    @Override
    public List<Moment> getMomentAll(long userid, int offset, int limit) {
        if (userid == 0) {
            throw new ParameterException("参数缺少");
        }
        List<Moment> moments = momentDao.queryAllMoment(userid, offset, limit);
//        List<Moment> tempList=moments;
        if(moments!=null){
            for(int i=0;i<moments.size();i++){
                Moment moment = moments.get(i);
                List<Long> imageids = moment.strToArray(moment.getImageres());
                for(Long resourceid:imageids){
                    Resource resource = resourceDao.queryResourceByResourceid(resourceid);
                    if(resource!=null){
                        moments.get(i).addImage(resource.getImagepath());
                    }
                }
                List<Long> videolist = moment.strToArray(moment.getVideores());
                for(Long resourceid:videolist){
                    Resource resource = resourceDao.queryResourceByResourceid(resourceid);
                    if(resource!=null){
                        moments.get(i).addvideo(resource.getImagepath());
                    }
                }

            }
        }
        return moments;
    }

    @Override
    public int deleteMoment(long momentid) {
        if (momentid == 0) {
            throw new ParameterException("参数缺少");
        }
        return momentDao.deleteMomentByMomentId(momentid);
    }

    @Override
    public int deleteMomentByUserid(long userid) {
        if (userid == 0) {
            throw new ParameterException("参数缺少");
        }
        return momentDao.deleteMomentByUserId(userid);
    }
}
