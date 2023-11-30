package umc.springUMC.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springUMC.apiPayload.code.status.ErrorStatus;
import umc.springUMC.apiPayload.exception.handler.StoreHandler;
import umc.springUMC.converter.MissionConverter;
import umc.springUMC.domain.Mission;
import umc.springUMC.domain.Store;
import umc.springUMC.repository.MissionRepository;
import umc.springUMC.repository.StoreRepository;
import umc.springUMC.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.AddMissionDTO request) {

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(request, store);
        return missionRepository.save(mission);
    }
}
