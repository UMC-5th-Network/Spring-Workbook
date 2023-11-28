package umc5th.homework.service;

import umc5th.homework.domain.Store;
import umc5th.homework.web.dto.StoreDTO;

public interface StoreService {
    Store addStore(StoreDTO.AddDTO addDTO);
}
