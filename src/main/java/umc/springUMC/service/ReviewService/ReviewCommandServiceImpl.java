package umc.springUMC.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.springUMC.domain.Review;
import umc.springUMC.repository.ReviewRepository;
import umc.springUMC.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

        private final ReviewRepository reviewRepository;

        @Override
        public Review writeReview(ReviewRequestDTO.WriteReviewDTO request) {
            return null;
        }

}
