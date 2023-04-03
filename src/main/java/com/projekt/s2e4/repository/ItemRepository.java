package com.projekt.s2e4.repository;

import com.projekt.s2e4.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
    @Query(
            value = "select item" +
                    "where inventory > : value"
            , nativeQuery = true
    )
    public List<Item> getByInventory(@Param(value = "value") Long amount);


    @Query(
            value = "delete item" +
                    "where inventory = 0"
            , nativeQuery = true
    )
    public void deleteZeroInventory();
}