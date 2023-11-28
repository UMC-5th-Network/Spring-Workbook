package umc5th.homework.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.homework.converter.MissionConverter;
import umc5th.homework.domain.Mission;
import umc5th.homework.domain.Store;
import umc5th.homework.repository.MissionRepository;
import umc5th.homework.repository.StoreRepository;
import umc5th.homework.web.dto.MissionDTO;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MissionService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Mission addMission(MissionDTO.AddRequestDTO requestDTO){
        Optional<Store> store = storeRepository.findById(requestDTO.getStoreId());

        if(store.isEmpty()){
            log.info("store: {}", store);
            new IllegalArgumentException("없는 store");
        }

        Mission mission = MissionConverter.toMission(requestDTO, store.get());
        missionRepository.save(mission);

        return mission;
    }
}