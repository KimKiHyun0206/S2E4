package com.projeckt.s2e4.dto.item.request;

import lombok.Data;

@Data
public class ItemRegisterRequest {
    private String itemName;
    private Long price;
    private Long inventory;
}
