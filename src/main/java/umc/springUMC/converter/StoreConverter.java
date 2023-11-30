package umc.springUMC.converter;

import umc.springUMC.domain.Map;
import umc.springUMC.domain.Store;
import umc.springUMC.web.dto.StoreRequestDTO;
import umc.springUMC.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    // Store entity 받아서 ResponseDTO로 만듦
    public static StoreResponseDTO.AddStoreResultDTO toAddStoreResultDTO(Store store) {
        return StoreResponseDTO.AddStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // RequestDTO 받아서 Store entity 생성
    public static Store toStore(StoreRequestDTO.AddStoreDto request, Map map) {
        Store store = Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .build();

        store.setMap(map);

        return store;
    }
}
