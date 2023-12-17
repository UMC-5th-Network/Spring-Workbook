package umc.springUMC.converter;

import umc.springUMC.domain.Review;
import umc.springUMC.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.WriteReviewResultDTO toWriteReviewResultDTO(Review review) {
        return ReviewResponseDTO.WriteReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
