package umc5th.homework.converter;

import umc5th.homework.domain.Region;
import umc5th.homework.domain.Store;
import umc5th.homework.web.dto.StoreDTO;

import java.util.ArrayList;

public class StoreConverter {

    public static StoreDTO.AddResponseDTO toAddDto(Store store){
        return StoreDTO.AddResponseDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreDTO.AddDTO addDTO, Region region){
        Store store = Store.builder()
                .name(addDTO.getName())
                .score(addDTO.getScore())
                .address(addDTO.getAddress())
                .build();

        store.setRegion(region);

        return store;
    }
}
