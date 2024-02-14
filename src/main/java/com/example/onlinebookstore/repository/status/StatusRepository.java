package com.example.onlinebookstore.repository.status;

import com.example.onlinebookstore.model.Status;
import com.example.onlinebookstore.model.enums.StatusName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByStatusName(StatusName statusName);
}
