package com.wisn.service;

import com.wisn.entity.Moment;
import com.wisn.entity.Resource;

import java.util.List;

public interface MomentService {
     int saveMoment(Moment moment);
    Moment getMoment(long momentid);
    List<Moment> getMomentAll(long userid,int offset ,int limit);
    int deleteMoment(long momentid);
    int deleteMomentByUserid(long userid);
}
