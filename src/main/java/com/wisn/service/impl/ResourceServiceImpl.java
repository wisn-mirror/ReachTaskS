package com.wisn.service.impl;

import com.wisn.dao.ResourceDao;
import com.wisn.entity.Resource;
import com.wisn.exception.ParameterException;
import com.wisn.service.ResourceService;
import com.wisn.tools.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResourceServiceImpl implements ResourceService{
    @Autowired
    ResourceDao  resourceDao;

    @Override
    public Resource saveResource(Resource resource) {
        if (resource==null||TextUtils.isEmpty(resource.getImagepath())  ) {
            throw new ParameterException("参数缺少");
        }
        resource.setCreatetime(System.currentTimeMillis());
        int resourceId = resourceDao.insertResource(resource);
        resource.setResourceid(resourceId);
        return resource;
    }

    @Override
    public Resource getResource(long resourceid) {
        if (resourceid==0) {
            throw new ParameterException("参数缺少");
        }
        Resource resource = resourceDao.queryResourceByResourceid(resourceid);
        return resource;
    }

    @Override
    public int deleteResource(long resourceid) {
        if (resourceid==0) {
            throw new ParameterException("参数缺少");
        }
        return resourceDao.deleteResourceByResourceId(resourceid);
    }
}
