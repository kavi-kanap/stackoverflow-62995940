package com.example.label;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class SwitchCaseEntity {
    @Id
    private UUID uuid;

    @Column(name = "label_switch_uuid", nullable = false)
    private UUID labelSwitchUUID;

    public SwitchCaseEntity() {
    }

    public SwitchCaseEntity(UUID uuid, UUID labelSwitchUUID) {
        this.uuid = uuid;
        this.labelSwitchUUID = labelSwitchUUID;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getLabelSwitchUUID() {
        return labelSwitchUUID;
    }

    public void setLabelSwitchUUID(UUID labelSwitchUUID) {
        this.labelSwitchUUID = labelSwitchUUID;
    }
}
