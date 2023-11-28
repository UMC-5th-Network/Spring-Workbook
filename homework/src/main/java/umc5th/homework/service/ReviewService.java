package umc5th.homework.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.homework.converter.ReviewConverter;
import umc5th.homework.domain.Member;
import umc5th.homework.domain.Review;
import umc5th.homework.domain.Store;
import umc5th.homework.repository.MemberRepository;
import umc5th.homework.repository.ReviewRepository;
import umc5th.homework.repository.StoreRepository;
import umc5th.homework.web.dto.ReviewDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;


    @Transactional
    public Review addReview(ReviewDTO.AddRequestDTO request){
        Optional<Store> store = storeRepository.findById(request.getScoreId());
        Optional<Member> member = memberRepository.findById(request.getMemberId());

        if (store.isEmpty() || member.isEmpty()) {
            new IllegalArgumentException("리뷰 추가 에러");
            log.info("리뷰 추가 에러.{}, {}", store, member);
        }
        Review review = ReviewConverter.toReview(request, member.get(), store.get());

        reviewRepository.save(review);
        return review;
    }
}
