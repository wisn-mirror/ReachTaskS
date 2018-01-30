package com.wisn.service.impl;

import com.wisn.dao.MomentDao;
import com.wisn.entity.Moment;
import com.wisn.exception.ParameterException;
import com.wisn.service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MomentServiceImpl implements MomentService {

    @Autowired
    MomentDao momentDao;

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
    public List<Moment> getMomentAll(long momentid, int offset, int limit) {
        if (momentid == 0) {
            throw new ParameterException("参数缺少");
        }
        return momentDao.queryAllMoment(momentid, offset, limit);
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
