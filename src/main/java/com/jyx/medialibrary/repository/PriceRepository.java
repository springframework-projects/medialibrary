package com.jyx.medialibrary.repository;

import com.jyx.medialibrary.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
}
