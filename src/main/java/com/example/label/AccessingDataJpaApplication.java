package com.example.label;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Collectors;

@SpringBootApplication
public class AccessingDataJpaApplication {

	@Autowired
    MyService service;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AccessingDataJpaApplication.class);
		MyService service = context.getBean(MyService.class);

		//Put a breakpoint and check all the children of saved.
		LabelValueEntity saved = service.save();

		String labelSwitchEntitiesBeforeUpdate = saved.getLabelSwitchEntities()
				.stream()
				.map(LabelSwitchEntity::getName)
				.collect(Collectors.joining(","));
		System.out.println("labelSwitchEntitiesBeforeUpdate : " + labelSwitchEntitiesBeforeUpdate);

		//Put a breakpoint and check all the children of updated.
		LabelValueEntity labelValueEntity = service.updateLabelValue();

		String labelSwitchEntitiesAfterUpdate = labelValueEntity.getLabelSwitchEntities()
				.stream()
				.map(LabelSwitchEntity::getName)
				.collect(Collectors.joining(","));
		System.out.println("labelSwitchEntitiesAfterUpdate : " + labelSwitchEntitiesAfterUpdate);
	}
}


