package umc.springUMC.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springUMC.converter.StoreConverter;
import umc.springUMC.domain.Map;
import umc.springUMC.domain.Store;
import umc.springUMC.repository.MapRepository;
import umc.springUMC.repository.StoreRepository;
import umc.springUMC.web.dto.StoreRequestDTO;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final MapRepository mapRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.AddStoreDto request) {
        Map map = mapRepository.findById(request.getMapId()).orElseThrow(() -> new EntityNotFoundException("Map not found : " + request.getMapId()));

        Store store = StoreConverter.toStore(request, map);

        return storeRepository.save(store);
    }
}
