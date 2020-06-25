package com.cooler.ai.platform.facade;

import com.cooler.ai.platform.facade.model.DMRequest;
import com.cooler.ai.platform.facade.model.DMResponse;

public interface DistributionCenterFacade {

    /**
     * distributionCenter的任务：决策、分发请求到对应bot，获得相关的数据进行返回。
     * 获得了dmRequest后，通过里面的参数，获得上下文数据集合List<DialogState>和业务数据，通过dmRequest里面的槽位和历史槽位（可能以后
     * 还有业务数据的作用），来决策出合理的领域、意图和task，由这些数据决策出一个dialogState，然后将上面的3个数据体传出来交给指定的bot处
     * 理。
     */

    DMResponse distributeProcess(DMRequest dmRequest);

}
