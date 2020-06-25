package com.cooler.ai.platform.service.impl;

import com.alibaba.fastjson.JSON;
import com.cooler.ai.platform.facade.constance.Constant;
import com.cooler.ai.platform.facade.constance.PC;
import com.cooler.ai.platform.facade.model.*;
import com.cooler.ai.platform.service.CacheService;
import com.cooler.ai.platform.service.ContextService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by zhangsheng on 2018/5/31.
 */
@Service("contextService")
public class ContextServiceImpl implements ContextService {

    private Logger logger = LoggerFactory.getLogger(ContextServiceImpl.class);

    @Resource
    private CacheService<DialogState> dialogStateCacheService;

    @Resource
    private CacheService<Map<String, BizDataModelState<String>>> bizDataCacheService;

    @Resource
    private CacheService<DomainTaskData> turnNumCacheService;


    @Override
    public void initCusParams(DMRequest dmRequest) {
        logger.debug("1.1.2-----------------得到的请求数据 dmRequest: ----> " + JSON.toJSONString(dmRequest));
    }

    @Override
    public List<DialogState> getContext(DMRequest dmRequest) {
        logger.debug("1.2.-----------------ContextServiceImpl.getContext(dmRequest) 创建/恢复多轮历史DialogState结构体");

        //1.获取上一轮的domainTaskData，进而构建各个上下文的key集合
        String sessionId = dmRequest.getSessionId();
        DomainTaskData domainTaskData = turnNumCacheService.getContext(sessionId + "_" + Constant.DOMAIN_TASK_DATA);
        if(domainTaskData == null){
            domainTaskData = new DomainTaskData(sessionId, 0, new HashMap());
        }

        List<String> historyKeys = new ArrayList<>();
        String queryType = dmRequest.getQueryType();
        if(Constant.NON_LANGUAGE_QUERYTYPES.contains(queryType)){
            Map<String, String> metaData = dmRequest.getMetaData();
            String domainName = metaData.get(PC.DOMAIN_NAME);
            String taskName = metaData.get(PC.TASK_NAME);
            Integer domainTaskTurnNum = domainTaskData.getTurnNumMap().get(domainName + "::" + taskName);
            domainTaskTurnNum = domainTaskTurnNum != null ? domainTaskTurnNum : 0;
            historyKeys.add(sessionId + "_" + domainName + "::" + taskName + "_" + domainTaskTurnNum + "_" + Constant.DIALOG_STATE);
        }else if(Constant.LANGUAGE_QUERYTYPES.contains(queryType)){
            Map<String, Integer> turnNumMap = domainTaskData.getTurnNumMap();
            if(turnNumMap.size() > 0){
                for (String domainTaskKey : turnNumMap.keySet()) {
                    if(domainTaskKey.contains("::")){
                        Integer domainTaskTurnNum = turnNumMap.get(domainTaskKey);
                        historyKeys.add(sessionId + "_" + domainTaskKey + "_" + domainTaskTurnNum + "_" + Constant.DIALOG_STATE);
                    }
                }
            }
        }

        dmRequest.setDomainTaskData(domainTaskData);                                                                          //设置当前轮的turnNum

        //3.开始查询
        if(historyKeys.size() > 0){
            try {
                logger.debug("1.2.a.传入cacheService的入参, historyKeys : " + JSON.toJSONString(historyKeys));
                List<DialogState> historyDialogStates = dialogStateCacheService.getContextList(historyKeys);
                List<DialogState> validatedDialogStates = new ArrayList<>();
                if(historyDialogStates != null && historyDialogStates.size() > 0){
                    for (DialogState historyDialogState : historyDialogStates) {
                        if(historyDialogState != null){
                            validatedDialogStates.add(historyDialogState);
                        }
                    }
                }
                Collections.sort(validatedDialogStates, new Comparator<DialogState>() {
                    @Override
                    public int compare(DialogState o1, DialogState o2) {
                        return o1.getTotalTurnNum() > o2.getTotalTurnNum() ? 1 : -1;
                    }
                });
                return validatedDialogStates;

            } catch (Exception e) {
                e.printStackTrace();
                logger.error("1.2.c.SessionService获取DialogState失败！" + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Map<String, BizDataModelState<String>> getBizData(DMRequest dmRequest) {
        String sessionId = dmRequest.getSessionId();
        try {
            //获取累计业务数据
            Map<String, BizDataModelState<String>> bizDataModelStateMap = bizDataCacheService.getContext(sessionId + "_" + Constant.BIZ_DATA);
            if(bizDataModelStateMap == null) bizDataModelStateMap = new HashMap<>();
            return bizDataModelStateMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }


}
