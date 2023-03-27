package com.projeckt.s2e4.repository;

import com.projeckt.s2e4.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
