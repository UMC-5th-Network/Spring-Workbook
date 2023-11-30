package umc.springUMC.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springUMC.apiPayload.code.status.ErrorStatus;
import umc.springUMC.apiPayload.exception.handler.MemberHandler;
import umc.springUMC.apiPayload.exception.handler.MissionHandler;
import umc.springUMC.apiPayload.exception.handler.StoreHandler;
import umc.springUMC.converter.MemberMissionConverter;
import umc.springUMC.converter.MissionConverter;
import umc.springUMC.domain.Member;
import umc.springUMC.domain.Mission;
import umc.springUMC.domain.Store;
import umc.springUMC.domain.mapping.MemberMission;
import umc.springUMC.repository.MemberMissionRepository;
import umc.springUMC.repository.MemberRepository;
import umc.springUMC.repository.MissionRepository;
import umc.springUMC.repository.StoreRepository;
import umc.springUMC.web.dto.MemberMissionRequestDTO;
import umc.springUMC.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.AddMissionDTO request) {

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(request, store);
        return missionRepository.save(mission);
    }

    @Override
    @Transactional
    public MemberMission challenging(MemberMissionRequestDTO.AddMMDTO request) {

        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(request, member, mission);

        return memberMissionRepository.save(memberMission);
    }
}
