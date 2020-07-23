package com.example.label;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.UUID;

@Service
public class MyService {

    public static final UUID LABEL_VALUE_ID = UUID.randomUUID();

    public static final UUID LABEL_SWITCH_ID_1 = UUID.randomUUID();
    public static final UUID LABEL_SWITCH_ID_2 = UUID.randomUUID();
    public static final UUID LABEL_SWITCH_ID_3 = UUID.randomUUID();

    public static final UUID SWITCH_CASE_ID_1 = UUID.randomUUID();
    public static final UUID SWITCH_CASE_ID_2 = UUID.randomUUID();
    public static final UUID SWITCH_CASE_ID_3 = UUID.randomUUID();
    @Autowired
    LabelValueRepository repository;

    @Transactional
    public LabelValueEntity save() {
        LabelSwitchEntity switchEntityOne = new LabelSwitchEntity(LABEL_SWITCH_ID_1, LABEL_VALUE_ID, "first");
        LabelSwitchEntity switchEntityTwo = new LabelSwitchEntity(LABEL_SWITCH_ID_2, LABEL_VALUE_ID, "second");

        SwitchCaseEntity caseEntityOne = new SwitchCaseEntity(SWITCH_CASE_ID_1, LABEL_SWITCH_ID_1);
        SwitchCaseEntity caseEntityTwo = new SwitchCaseEntity(SWITCH_CASE_ID_2, LABEL_SWITCH_ID_1);

        switchEntityOne.setSwitchCaseEntities(Arrays.asList(caseEntityOne, caseEntityTwo));

        LabelValueEntity labelValueEntity = new LabelValueEntity(LABEL_VALUE_ID, Arrays.asList(switchEntityOne, switchEntityTwo));
        return repository.save(labelValueEntity);
    }

    @Transactional
    public LabelValueEntity updateLabelValue() {
        LabelValueEntity updatedEntity = new LabelValueEntity(LABEL_VALUE_ID);
        repository.saveAndFlush(updatedEntity);

        LabelSwitchEntity switchEntityOne = new LabelSwitchEntity(LABEL_SWITCH_ID_1, LABEL_VALUE_ID, "first");
        LabelSwitchEntity switchEntityThree = new LabelSwitchEntity(LABEL_SWITCH_ID_3, LABEL_VALUE_ID, "third");
        updatedEntity.setLabelSwitchEntities(Arrays.asList(switchEntityOne, switchEntityThree));

        SwitchCaseEntity caseEntityOne = new SwitchCaseEntity(SWITCH_CASE_ID_1, LABEL_SWITCH_ID_3);
        SwitchCaseEntity caseEntityThree = new SwitchCaseEntity(SWITCH_CASE_ID_3, LABEL_SWITCH_ID_3);

        switchEntityOne.setSwitchCaseEntities(Arrays.asList(caseEntityOne, caseEntityThree));

        return updatedEntity;
    }
}
