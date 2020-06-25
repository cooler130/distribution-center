package com.cooler.ai.platform.service.entity;

import com.cooler.ai.platform.entity.NLUIntent;

import java.util.List;

/**
 * Created by zhangsheng on 2018/6/20.
 */
public interface NLUIntentService {

    /**
     * 根据连接层意图名称和领域名称查询NLUIntent，获取intent_id
     * @param nluIntentName 连接层意图名
     * @param nluDomainName 连接层领域名
     * @return  DM内部intent_id
     */
    NLUIntent selectByTwoNames(String nluIntentName, String nluDomainName);

    /**
     * 根据nluIntentName查询对应的NLUIntent集合
     * @param nluIntentName
     * @return
     */
    List<NLUIntent> selectByIntentName(String nluIntentName);
}
