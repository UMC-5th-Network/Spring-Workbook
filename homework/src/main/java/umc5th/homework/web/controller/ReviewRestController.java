package umc5th.homework.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc5th.homework.apiPayload.ApiResponse;
import umc5th.homework.domain.Review;
import umc5th.homework.service.ReviewService;
import umc5th.homework.web.dto.ReviewDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {
    private final ReviewService reviewService;
    @PostMapping("/add")
    public ApiResponse<Long> add(@RequestBody @Valid ReviewDTO.AddRequestDTO request){
        Review review = reviewService.addReview(request);
        return ApiResponse.onSuccess(review.getId());
    }
}
