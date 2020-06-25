package com.cooler.ai.platform.service.impl.entity;

import com.cooler.ai.platform.dao.SlotRelationMapper;
import com.cooler.ai.platform.entity.SlotRelation;
import com.cooler.ai.platform.service.entity.SlotRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2018/12/17
 **/
@Service("slotRelationService")
public class SlotRelationServiceImpl implements SlotRelationService {

    @Autowired
    private SlotRelationMapper slotRelationMapper;

    @Override
    public List<SlotRelation> selectBySlotIds(List<Integer> slotIds) {
        return slotRelationMapper.selectBySlotIds(slotIds);
    }
}
