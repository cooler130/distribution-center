package com.cooler.ai.platform.service.entity;

import com.cooler.ai.platform.entity.SlotRelation;

import java.util.List;

/**
 * Created by zhangsheng on 2018/12/17.
 */
public interface SlotRelationService {
    /**
     * 根据slotIds查询nluSlotIds
     * @param slotIds
     * @return
     */
    List<SlotRelation> selectBySlotIds(List<Integer> slotIds);
}
