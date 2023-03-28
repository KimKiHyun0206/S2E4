package com.projeckt.s2e4.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "item")
@Getter
@Table(name = "item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price")
    private Long price;

    @Column(name = "inventory")
    private Long inventory;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Item(String itemName, Long price, Long inventory) {
        this.itemName = itemName;
        this.price = price;
        this.inventory = inventory;
    }

    public void update(String itemName, Long price, Long inventory){
        this.itemName = itemName;
        this.price = price;
        this.inventory = inventory;
    }

}
