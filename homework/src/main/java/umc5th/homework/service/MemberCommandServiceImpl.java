package umc5th.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.homework.apiPayload.code.status.ErrorStatus;
import umc5th.homework.apiPayload.exception.handler.FoodCategoryHandler;
import umc5th.homework.converter.MemberConverter;
import umc5th.homework.converter.MemberPreferConverter;
import umc5th.homework.domain.FoodCategory;
import umc5th.homework.domain.Member;
import umc5th.homework.domain.mapping.MemberPrefer;
import umc5th.homework.repository.FoodCategoryRepository;
import umc5th.homework.repository.MemberRepository;
import umc5th.homework.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}