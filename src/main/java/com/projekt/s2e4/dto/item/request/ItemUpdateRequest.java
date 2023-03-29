package com.projekt.s2e4.dto.item.request;

import lombok.Data;

@Data
public class ItemUpdateRequest {
    private String itemName;
    private Long price;
    private Long inventory;
}
