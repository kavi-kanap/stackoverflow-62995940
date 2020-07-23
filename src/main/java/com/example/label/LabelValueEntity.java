package com.example.label;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
public class LabelValueEntity {

    @Id
    private UUID uuid;

    @OneToMany(mappedBy = "labelValueUUID", cascade = ALL, fetch = EAGER, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<LabelSwitchEntity> labelSwitchEntities =  new ArrayList<>();

    public LabelValueEntity() {
    }

    public LabelValueEntity(UUID uuid) {
        this.uuid = uuid;
    }

    public LabelValueEntity(UUID uuid, List<LabelSwitchEntity> labelSwitchEntities) {
        this.uuid = uuid;
        this.labelSwitchEntities = labelSwitchEntities;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setLabelSwitchEntities(List<LabelSwitchEntity> labelSwitchEntities) {
        this.labelSwitchEntities = labelSwitchEntities;
    }

    public UUID getUuid() {
        return uuid;
    }

    public List<LabelSwitchEntity> getLabelSwitchEntities() {
        return labelSwitchEntities;
    }
}
