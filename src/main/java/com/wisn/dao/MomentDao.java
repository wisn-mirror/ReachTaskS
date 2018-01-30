package com.wisn.dao;

import com.wisn.entity.Moment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MomentDao {
    Moment queryMomentByMomentId(long momentid);

    List<Moment> queryAllMoment(long userid, @Param("offset") int offset, @Param("limit") int limit);

    List<Moment> queryAllMomentByCreateTime(long userid,long createtime);

    int insertMoment(Moment message);

    int deleteMomentByMomentId(long momentId);

    int deleteMomentByUserId(long userid);
}
