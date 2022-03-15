package com.arch.tvchannel.repository;

import com.arch.tvchannel.model.Thursday;
import com.arch.tvchannel.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThursdayRepository extends JpaRepository<Thursday, Long> {
}
