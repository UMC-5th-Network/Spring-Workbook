package umc5th.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.homework.apiPayload.code.status.ErrorStatus;
import umc5th.homework.apiPayload.exception.handler.FoodCategoryHandler;
import umc5th.homework.converter.StoreConverter;
import umc5th.homework.domain.Region;
import umc5th.homework.domain.Store;
import umc5th.homework.repository.RegionRepository;
import umc5th.homework.repository.StoreRepository;
import umc5th.homework.web.dto.StoreDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(StoreDTO.AddDTO addDTO) {
        //Optional<Region> region = Optional.ofNullable(regionRepository.findByName(addDTO.getRegion()).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)));
        //일단 임시
        Region region = regionRepository.findByName(addDTO.getRegion()).get();
        Store store = StoreConverter.toStore(addDTO, region);
        storeRepository.save(store);
        return store;
    }
}
