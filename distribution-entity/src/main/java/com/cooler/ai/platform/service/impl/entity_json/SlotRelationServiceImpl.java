package com.cooler.ai.platform.service.impl.entity_json;

import com.alibaba.fastjson.JSON;
import com.cooler.ai.platform.EntityConstant;
import com.cooler.ai.platform.entity.SlotRelation;
import com.cooler.ai.platform.service.entity.SlotRelationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2018/12/17
 **/
@Service("jsonSlotRelationService")
public class SlotRelationServiceImpl implements SlotRelationService {

    private static Map<String, String> globalMap = EntityConstant.globalMap;

    @Override
    public List<SlotRelation> selectBySlotIds(List<Integer> slotIds) {
        if(slotIds == null || slotIds.size() == 0){
            return null;
        }
        List<SlotRelation> slotRelations = new ArrayList<>();
        for (Integer slotId : slotIds) {
            String json = globalMap.get("SlotRelation_" + slotId);
            if(json != null){
                List<SlotRelation> slotRelationsGroup = JSON.parseArray(json, SlotRelation.class);
                slotRelations.addAll(slotRelationsGroup);
            }
        }
        return slotRelations;
    }
}
