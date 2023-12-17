package umc.springUMC.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springUMC.apiPayload.code.status.ErrorStatus;
import umc.springUMC.apiPayload.exception.handler.FoodCategoryHandler;
import umc.springUMC.converter.MemberConverter;
import umc.springUMC.converter.MemberFavorConverter;
import umc.springUMC.domain.FoodCategory;
import umc.springUMC.domain.Member;
import umc.springUMC.domain.Review;
import umc.springUMC.domain.enums.MissionStatus;
import umc.springUMC.domain.mapping.MemberFavor;
import umc.springUMC.domain.mapping.MemberMission;
import umc.springUMC.repository.FoodCategoryRepository;
import umc.springUMC.repository.MemberMissionRepository;
import umc.springUMC.repository.MemberRepository;
import umc.springUMC.repository.ReviewRepository;
import umc.springUMC.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);

        List<FoodCategory> foodCategoryList = request.getFavorCategory().stream()
                .map(category -> {  // validation을 어노테이션 사용하도록 리팩토링 가능.
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberFavor> memberFavorList = MemberFavorConverter.toMemberFavorList(foodCategoryList);

        memberFavorList.forEach(memberFavor -> {memberFavor.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    public boolean existMember(List<Long> values) {
        return values.stream()
                .allMatch(value -> memberRepository.existsById(value));
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        Page<Review> reviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return reviewPage;
    }

    @Override
    public Page<MemberMission> getMemberMissionList(Long memberId, String missionStatus, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        MissionStatus status = MissionStatus.valueOf(missionStatus);

        Page<MemberMission> missionPage = memberMissionRepository.findAllByMemberAndStatus(member, status, PageRequest.of(page, 10));
        return missionPage;
    }
}
