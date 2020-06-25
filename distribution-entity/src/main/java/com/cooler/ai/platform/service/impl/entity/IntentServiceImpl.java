package com.cooler.ai.platform.service.impl.entity;

import com.cooler.ai.platform.dao.IntentMapper;
import com.cooler.ai.platform.entity.Intent;
import com.cooler.ai.platform.service.entity.IntentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangsheng on 2018/6/26.
 */
@Service("intentService")
public class IntentServiceImpl implements IntentService {

    @Autowired
    private IntentMapper intentMapper;


    @Override
    public Intent selectByIntentId(Integer intentId) {
        return intentMapper.selectByIntentId(intentId);
    }

    @Override
    public Intent selectByTwoNames(String domainName, String intentName) {
        return intentMapper.selectByTwoNames(domainName, intentName);
    }
}
