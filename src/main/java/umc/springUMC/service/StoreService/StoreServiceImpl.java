package umc.springUMC.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springUMC.apiPayload.code.status.ErrorStatus;
import umc.springUMC.apiPayload.exception.handler.MapHandler;
import umc.springUMC.converter.StoreConverter;
import umc.springUMC.domain.Map;
import umc.springUMC.domain.Mission;
import umc.springUMC.domain.Review;
import umc.springUMC.domain.Store;
import umc.springUMC.repository.MapRepository;
import umc.springUMC.repository.MissionRepository;
import umc.springUMC.repository.ReviewRepository;
import umc.springUMC.repository.StoreRepository;
import umc.springUMC.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final MapRepository mapRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

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

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));

        return StorePage;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Mission> storePage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return storePage;
    }
}
