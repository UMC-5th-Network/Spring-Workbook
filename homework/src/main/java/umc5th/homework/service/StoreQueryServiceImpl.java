package umc5th.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.homework.domain.Member;
import umc5th.homework.domain.Mission;
import umc5th.homework.domain.Review;
import umc5th.homework.domain.Store;
import umc5th.homework.repository.MemberRepository;
import umc5th.homework.repository.MissionRepository;
import umc5th.homework.repository.ReviewRepository;
import umc5th.homework.repository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Mission> missions = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return missions;
    }

    @Override
    public Page<Review> getReviewListByStore(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return storePage;
    }

    @Override
    public Page<Review> getReviewListByMember(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        Page<Review> storePage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return storePage;
    }
}
