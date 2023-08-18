package com.oit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudItemRepository extends JpaRepository<cruditem, Long> {
    // You can define custom queries here if needed
}