package com.cooler.ai.platform.service.impl.entity_json;

import com.alibaba.fastjson.JSONObject;
import com.cooler.ai.platform.EntityConstant;
import com.cooler.ai.platform.entity.NLUIntent;
import com.cooler.ai.platform.service.entity.NLUIntentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangsheng on 2018/6/20.
 */
@Service("jsonNLUIntentService")
public class NLUIntentServiceImpl implements NLUIntentService {

    private static Map<String, String> globalMap = EntityConstant.globalMap;

    @Override
    public NLUIntent selectByTwoNames(String nluIntentName, String nluDomainName) {
        NLUIntent nluIntent = null;
        String json = globalMap.get("NLUIntent_" + nluDomainName + "_" + nluIntentName);
        if(json != null){
            nluIntent = JSONObject.parseObject(json, NLUIntent.class);
        }
        return nluIntent;
    }

    @Override
    public List<NLUIntent> selectByIntentName(String nluIntentName) {
        List<NLUIntent> nluIntents = null;
        String json = globalMap.get("NLUIntent_" + nluIntentName);
        if(json != null){
            nluIntents = JSONObject.parseArray(json, NLUIntent.class);
        }
        return nluIntents;
    }
}
