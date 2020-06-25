package com.cooler.ai.platform.dao;

import com.cooler.ai.platform.entity.Slot;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlotMapper {

    List<Slot> selectByIntentId(@Param("intentId") Integer intentId);
}