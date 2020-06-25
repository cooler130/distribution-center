package com.cooler.ai.platform.facade.impl;

import com.cooler.ai.platform.facade.DMFacade;
import com.cooler.ai.platform.facade.DistributionCenterFacade;
import com.cooler.ai.platform.facade.model.*;
import com.cooler.ai.platform.service.ContextService;
import com.cooler.ai.platform.service.DMFacadeMapService;
import com.cooler.ai.platform.service.SlotOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("distributionCenterFacade")
public class DistributionCenterFacadeImpl implements DistributionCenterFacade {

    @Autowired
    private ContextService contextService;                                                                              //1.对话上下文服务

    //下面是正式环境所使用的组件
    @Qualifier("slotOperateJsonService")
    @Autowired
    private SlotOperateService slotOperateService;                                                                      //2.1.对话状态追踪服务（两个版本：json版）

    @Qualifier("slotOperateService")
    @Autowired
    private SlotOperateService slotOperateService2;                                                                     //2.2.对话状态追踪服务（两个版本：db版）

    @Qualifier("xmlDMFacadeMapService")
    @Autowired
    private DMFacadeMapService dmFacadeMapService;                                                                      //3.facade映射服务（当前在xml注册各个服务，以后还可以设计其他版本，例如将映射关系放到数据库中）

    @Override
    public DMResponse distributeProcess(DMRequest dmRequest) {
        long startTimeStamp = System.currentTimeMillis();

        DialogState dialogState = null;

        contextService.initCusParams(dmRequest);                                                                            //0.参数初始化（定制化参数初始化（从DB中加载））

        List<DialogState> historyDialogStates = contextService.getContext(dmRequest);                                       //1.读取多轮历史保存对话状态数据（创建/恢复DM结构体）
        Map<String, BizDataModelState<String>> bizDataMSMap = contextService.getBizData(dmRequest);                     //（全量业务数据集）此bizDataMap用来装载动作执行过程中产生的业务数据，此数据形式多变，无法标准化，也无法确定每一轮能产生多少

        if (!dmRequest.isDebugModel()) {                                                                                  //非调试状态，后端接入的是json文件内部数据（用于正式环境）
            dialogState = slotOperateService.operationSlots(dmRequest, historyDialogStates, bizDataMSMap);                  //  2.对话填槽补槽，多个（领域，意图）对中决策出一个，槽位值操作（确定领域和意图，对槽位值的增删改操作，构建DS）
        } else {                                                                                                        //调试状态，后端接入的是数据库中的数据（用于线下测试环境和管理环境）
            dialogState = slotOperateService2.operationSlots(dmRequest, historyDialogStates, bizDataMSMap);
        }

        DistributionData distributionData = new DistributionData(dmRequest, dialogState, bizDataMSMap);
        DMFacade dmFacade = dmFacadeMapService.getFacadeName(dialogState.getBotName());
        DMResponse dmResponse = dmFacade.process(distributionData);

        long endTimeStamp = System.currentTimeMillis();

        dmResponse.setReceiveTime(startTimeStamp);
        dmResponse.setReturnTime(endTimeStamp);

        return dmResponse;
    }
}