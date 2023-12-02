package umc.springUMC.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.springUMC.apiPayload.ApiResponse;
import umc.springUMC.converter.ReviewConverter;
import umc.springUMC.domain.Review;
import umc.springUMC.service.MemberService.MemberCommandService;
import umc.springUMC.service.ReviewService.ReviewCommandService;
import umc.springUMC.web.dto.ReviewRequestDTO;
import umc.springUMC.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final MemberCommandService memberCommandService;
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.WriteReviewResultDTO> writeReview(@RequestBody @Valid ReviewRequestDTO.WriteReviewDTO request) {

        Review review = reviewCommandService.writeReview(request);
        ReviewResponseDTO.WriteReviewResultDTO resultDTO = ReviewConverter.toWriteReviewResultDTO(review);
        return ApiResponse.onSuccess(resultDTO);
    }
}
