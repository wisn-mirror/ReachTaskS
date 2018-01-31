package com.wisn.service.impl;

import com.wisn.dao.ResourceDao;
import com.wisn.entity.Resource;
import com.wisn.exception.ParameterException;
import com.wisn.service.ResourceService;
import com.wisn.tools.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ResourceServiceImpl implements ResourceService{
    @Autowired
    ResourceDao  resourceDao;

    @Override
    @Transactional
//    @Transactional
    /**
     * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    public Resource saveResource(Resource resource) {
        if (resource==null||TextUtils.isEmpty(resource.getImagepath())  ) {
            throw new ParameterException("参数缺少");
        }
        resource.setCreatetime(System.currentTimeMillis());
        long resourceId = resourceDao.insertResource(resource);
        System.out.println("saveResource:"+resourceId+ "resource: "+resource);
//        resource.setResourceid(resourceId);
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
