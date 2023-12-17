package umc.springUMC.service.StoreService;

import umc.springUMC.domain.Store;
import umc.springUMC.web.dto.StoreRequestDTO;

import java.util.List;

public interface StoreCommandService {

    Store addStore(StoreRequestDTO.AddStoreDto request);

    boolean existStore(List<Long> values);
}
