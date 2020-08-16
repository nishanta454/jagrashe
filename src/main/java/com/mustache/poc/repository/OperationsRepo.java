package com.mustache.poc.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mustache.poc.entity.Operation;

@Repository
public interface OperationsRepo extends JpaRepository<Operation, UUID> {
   Operation findFirstByCampaignIdAndFieldName(String campaignId, String fieldName);
}
