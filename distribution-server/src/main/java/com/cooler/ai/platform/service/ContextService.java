package com.cooler.ai.platform.service;

import com.cooler.ai.platform.facade.model.BizDataModelState;
import com.cooler.ai.platform.facade.model.DMRequest;
import com.cooler.ai.platform.facade.model.DialogState;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangsheng on 2018/5/29.
 */
public interface ContextService {

    /**
     * 定制化参数初始化
     * @param dmRequest DM的请求数据
     */
    void initCusParams(DMRequest dmRequest);                                                    //todo：可能此函数不该放到这个接口，应该另起一个接口

    /**
     * 获取多轮历史上下文
     * @param dmRequest DM的请求数据
     * @return  DM结构体数据
     */
    List<DialogState> getContext(DMRequest dmRequest);

    /**
     * 获取历史业务数据
     * @param dmRequest DM的请求数据
     * @return  历史业务数据
     */
    Map<String, BizDataModelState<String>> getBizData(DMRequest dmRequest);


}
