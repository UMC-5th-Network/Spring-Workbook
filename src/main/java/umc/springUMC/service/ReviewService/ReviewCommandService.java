package umc.springUMC.service.ReviewService;

import umc.springUMC.domain.Review;
import umc.springUMC.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Review writeReview(Long memberId, ReviewRequestDTO.WriteReviewDTO request);
}
