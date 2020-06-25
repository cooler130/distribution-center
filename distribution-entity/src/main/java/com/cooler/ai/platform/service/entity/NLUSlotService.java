package com.cooler.ai.platform.service.entity;

import com.cooler.ai.platform.entity.NLUSlot;

import java.util.List;
import java.util.Set;


/**
 * Created by zhangsheng on 2018/6/20.
 */
public interface NLUSlotService {

    /**
     * 根据slotIds查询相关的NLUSlot集合
     * @param ids   当前intentId的所有slotId集合
     * @return  对应的nluSlot集合
     */
    List<NLUSlot> selectByIds(Set<Integer> ids);
}
