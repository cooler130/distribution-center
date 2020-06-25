package com.cooler.ai.platform.dao;

import com.cooler.ai.platform.entity.NLUSlot;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface NLUSlotMapper {

    List<NLUSlot> selectByIds(@Param("ids") Set<Integer> ids);
}