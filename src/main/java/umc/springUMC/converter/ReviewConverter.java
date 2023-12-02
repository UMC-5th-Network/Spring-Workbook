package umc.springUMC.converter;

import umc.springUMC.domain.Member;
import umc.springUMC.domain.Review;
import umc.springUMC.domain.Store;
import umc.springUMC.web.dto.ReviewRequestDTO;
import umc.springUMC.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewConverter {

    public static ReviewResponseDTO.WriteReviewResultDTO toWriteReviewResultDTO(Review review) {
        return ReviewResponseDTO.WriteReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview (ReviewRequestDTO.WriteReviewDTO request, Member member, Store store) {

        return Review.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return null;
    }

    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(List<Review> reviewList) {
        return null;
    }
}
