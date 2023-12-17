package umc.springUMC.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springUMC.apiPayload.code.status.ErrorStatus;
import umc.springUMC.apiPayload.exception.handler.MapHandler;
import umc.springUMC.converter.StoreConverter;
import umc.springUMC.domain.Map;
import umc.springUMC.domain.Store;
import umc.springUMC.repository.MapRepository;
import umc.springUMC.repository.StoreRepository;
import umc.springUMC.web.dto.StoreRequestDTO;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final MapRepository mapRepository;

    // storeRepository에 store 추가
    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.AddStoreDto request) {
        Map map = mapRepository.findById(request.getMapId()).orElseThrow(() -> new MapHandler(ErrorStatus.MAP_NOT_FOUND));

        Store store = StoreConverter.toStore(request, map);

        return storeRepository.save(store);
    }

    @Override
    public boolean existStore(List<Long> values) {
        return values.stream()
                .allMatch(value -> storeRepository.existsById(value));
    }
}
