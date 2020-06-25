package com.cooler.ai.platform.service.entity;

import com.cooler.ai.platform.entity.Intent;

/**
 * Created by zhangsheng on 2018/6/20.
 */
public interface IntentService {


    Intent selectByIntentId(Integer intentId);

    Intent selectByTwoNames(String domainName, String intentName);
}
