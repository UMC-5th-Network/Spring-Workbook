package umc.springUMC.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.springUMC.apiPayload.code.status.ErrorStatus;
import umc.springUMC.apiPayload.exception.handler.MemberHandler;
import umc.springUMC.apiPayload.exception.handler.StoreHandler;
import umc.springUMC.converter.ReviewConverter;
import umc.springUMC.domain.Member;
import umc.springUMC.domain.Review;
import umc.springUMC.domain.Store;
import umc.springUMC.repository.MemberRepository;
import umc.springUMC.repository.ReviewRepository;
import umc.springUMC.repository.StoreRepository;
import umc.springUMC.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

        private final ReviewRepository reviewRepository;
        private final MemberRepository memberRepository;
        private final StoreRepository storeRepository;

        @Override
        public Review writeReview(ReviewRequestDTO.WriteReviewDTO request) {

            Member member = memberRepository.findById(request.getMemberId())
                    .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
            Store store = storeRepository.findById(request.getStoreId())
                    .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

            Review newReview = ReviewConverter.toReview(request, member, store);

            return reviewRepository.save(newReview);
        }

}
