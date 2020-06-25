package com.cooler.ai.platform.service.impl.entity_json;

import com.alibaba.fastjson.JSONObject;
import com.cooler.ai.platform.EntityConstant;
import com.cooler.ai.platform.entity.Slot;
import com.cooler.ai.platform.service.entity.SlotService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangsheng on 2018/6/21.
 */
@Service("jsonSlotService")
public class SlotServiceImpl implements SlotService {

    private static Map<String, String> globalMap = EntityConstant.globalMap;

    @Override
    public List<Slot> selectByIntentId(Integer intentId) {
        List<Slot> slots = null;
        String json = globalMap.get("Slot_" + intentId);
        if(json != null){
            slots = JSONObject.parseArray(json, Slot.class);
        }
        return slots;
    }
}
