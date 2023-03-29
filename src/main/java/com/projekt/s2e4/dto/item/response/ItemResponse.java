package com.projekt.s2e4.dto.item.response;

import com.projekt.s2e4.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ItemResponse {
    private Long id;
    private String itemName;
    private Long price;
    private Long inventory;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static ItemResponse from(Item item){
        return new ItemResponse(
                item.getId(),
                item.getItemName(),
                item.getPrice(),
                item.getInventory(),
                item.getCreatedAt(),
                item.getModifiedAt()
        );
    }
}
