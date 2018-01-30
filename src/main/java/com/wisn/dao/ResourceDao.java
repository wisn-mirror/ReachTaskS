package com.wisn.dao;

import com.wisn.entity.Resource;

public interface ResourceDao {
    Resource queryResourceByResourceid(long resourceid);

    int insertResource(Resource resource);

    int deleteResourceByResourceId(long Resourceid);
}
