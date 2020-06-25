package com.cooler.ai.platform.dao;

import com.cooler.ai.platform.entity.*;

import java.util.List;

public interface AllMapper {

    List<Intent> selectAllIntent();

    List<NLUIntent> selectAllNLUIntent();

    List<NLUSlot> selectAllNLUSlot();

    List<Slot> selectAllSlot();

    List<SlotRelation> selectAllSlotRelation();

}