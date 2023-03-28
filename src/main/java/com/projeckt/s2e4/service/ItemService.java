package com.projeckt.s2e4.service;

import com.projeckt.s2e4.dto.item.request.ItemRegisterRequest;
import com.projeckt.s2e4.dto.item.request.ItemUpdateRequest;
import com.projeckt.s2e4.dto.item.response.ItemResponse;
import com.projeckt.s2e4.entity.Item;
import com.projeckt.s2e4.exception.S2E4Exception;
import com.projeckt.s2e4.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public ItemResponse register(ItemRegisterRequest request){
        Item item = new Item(
                request.getItemName(),
                request.getPrice(),
                request.getInventory()
        );

        Item savedItem = itemRepository.save(item);

        log.info("Item 등록했습니다. {}", item.getId());

        return ItemResponse.from(item);
    }

    @Transactional(readOnly = true)
    public ItemResponse get(Long id){
        Item item = itemRepository.findById(id)
                .orElseThrow(S2E4Exception::new);

        log.info("Item 조회했습니다. {}", item.getId());

        return ItemResponse.from(item);
    }

    @Transactional
    public ItemResponse update(Long id, ItemUpdateRequest request){
        Item item = itemRepository.findById(id)
                .orElseThrow(S2E4Exception::new);

        item.update(
                request.getItemName(),
                request.getPrice(),
                request.getInventory()
        );

        log.info("Item 수정했습니다. {}", item.getId());

        return ItemResponse.from(item);
    }

    @Transactional
    public void delete(Long id){
        if(itemRepository.existsById(id)){
            itemRepository.deleteById(id);
            log.info("Item 삭제했습니다. {}", id);
        }else {
            log.info("Item 정보를 찾을 수 없습니다. {}", id);
        }
    }
}
