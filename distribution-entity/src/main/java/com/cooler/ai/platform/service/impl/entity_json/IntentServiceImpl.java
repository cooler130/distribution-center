package com.cooler.ai.platform.service.impl.entity_json;

import com.alibaba.fastjson.JSONObject;
import com.cooler.ai.platform.EntityConstant;
import com.cooler.ai.platform.entity.Intent;
import com.cooler.ai.platform.service.entity.IntentService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by zhangsheng on 2018/6/26.
 */
@Service("jsonIntentService")
public class IntentServiceImpl implements IntentService {

    private static Map<String, String> globalMap = EntityConstant.globalMap;

    @Override
    public Intent selectByIntentId(Integer intentId) {
        Intent intent = null;
        String json = globalMap.get("Intent_" + intentId);
        if(json != null){
            intent = JSONObject.parseObject(json, Intent.class);
        }
        return intent;
    }

    @Override
    public Intent selectByTwoNames(String domainName, String intentName) {
        Intent intent = null;
        String json = globalMap.get("Intent_" + domainName + "_" + intentName);
        if(json != null){
            intent = JSONObject.parseObject(json, Intent.class);
        }
        return intent;
    }
}
