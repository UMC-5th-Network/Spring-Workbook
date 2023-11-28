package umc5th.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.homework.converter.StoreConverter;
import umc5th.homework.domain.Region;
import umc5th.homework.repository.RegionRepository;
import umc5th.homework.web.dto.StoreDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionService {
    private final RegionRepository regionRepository;

    public Region getRegionByName(String name) {
        Optional<Region> find = regionRepository.findByName(name);

        if(find.isEmpty()){
            new IllegalAccessError("지역을 찾을 수 없음");
        }
        return find.get();
    }
}
