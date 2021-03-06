package com.mustache.poc.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String campaignId;

	private String fieldName;

	@Column(length = Integer.MAX_VALUE)
	private String operation;
}
