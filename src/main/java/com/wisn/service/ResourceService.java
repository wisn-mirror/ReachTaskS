package com.wisn.service;

import com.wisn.entity.Resource;

public interface ResourceService {
    Resource saveResource(Resource resource);
    Resource getResource(long resourceid);
    int deleteResource(long resourceid);
}
