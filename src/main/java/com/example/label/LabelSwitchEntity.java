package com.example.label;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
public class LabelSwitchEntity {

    @Id
    private UUID uuid;

    @Column(name = "label_value_uuid", nullable = false)
    private UUID labelValueUUID;

    @OneToMany(mappedBy = "labelSwitchUUID", cascade = ALL, fetch = EAGER, orphanRemoval = true)
    private List<SwitchCaseEntity> switchCaseEntities;

    @Column
    String name;

    public LabelSwitchEntity() {
    }

    public LabelSwitchEntity(UUID uuid, UUID labelValueUUID, String name) {
        this.uuid = uuid;
        this.labelValueUUID = labelValueUUID;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getLabelValueUUID() {
        return labelValueUUID;
    }

    public void setLabelValueUUID(UUID labelValueUUID) {
        this.labelValueUUID = labelValueUUID;
    }

    public List<SwitchCaseEntity> getSwitchCaseEntities() {
        return switchCaseEntities;
    }

    public void setSwitchCaseEntities(List<SwitchCaseEntity> switchCaseEntities) {
        this.switchCaseEntities = switchCaseEntities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
