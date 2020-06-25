package com.cooler.ai.platform.dao;

import com.cooler.ai.platform.entity.SlotRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlotRelationMapper {
    /**
     * 根据slotIds集合查询nluSlotIds
     * @param slotIds
     * @return  nluSlotIds
     */
    List<SlotRelation> selectBySlotIds(@Param("slotIds") List<Integer> slotIds);
}