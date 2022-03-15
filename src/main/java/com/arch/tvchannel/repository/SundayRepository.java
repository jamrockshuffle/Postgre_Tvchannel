package com.arch.tvchannel.repository;

import com.arch.tvchannel.model.Sunday;
import com.arch.tvchannel.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SundayRepository extends JpaRepository<Sunday, Long> {
}
