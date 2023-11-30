package umc.springUMC.service.StoreService;

import umc.springUMC.domain.Store;
import umc.springUMC.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store addStore(StoreRequestDTO.AddStoreDto request);
}
