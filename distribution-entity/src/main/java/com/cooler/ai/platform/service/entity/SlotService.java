package com.cooler.ai.platform.service.entity;

import com.cooler.ai.platform.entity.Slot;

import java.util.List;

/**
 * Created by zhangsheng on 2018/6/20.
 */
public interface SlotService {

    List<Slot> selectByIntentId(Integer intentId);

}
