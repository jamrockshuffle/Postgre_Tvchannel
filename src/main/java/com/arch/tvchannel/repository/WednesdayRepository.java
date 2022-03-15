package com.arch.tvchannel.repository;

import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.model.Wednesday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WednesdayRepository extends JpaRepository<Wednesday, Long> {
}
