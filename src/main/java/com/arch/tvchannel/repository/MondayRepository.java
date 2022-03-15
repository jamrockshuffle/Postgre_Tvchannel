package com.arch.tvchannel.repository;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MondayRepository extends JpaRepository<Monday, Long> {
}
