package umc.springUMC.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.springUMC.apiPayload.ApiResponse;
import umc.springUMC.converter.MemberConverter;
import umc.springUMC.domain.Member;
import umc.springUMC.service.MemberService.MemberCommandService;
import umc.springUMC.service.ReviewService.ReviewCommandService;
import umc.springUMC.web.dto.MemberRequestDTO;
import umc.springUMC.web.dto.MemberResponseDTO;
import umc.springUMC.web.dto.ReviewRequestDTO;
import umc.springUMC.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/reviews")
    public ApiResponse<ReviewResponseDTO.WriteReviewResultDTO> writeReview(@PathVariable Long memberId, @RequestBody @Valid ReviewRequestDTO.WriteReviewDTO request) {
        return null;
    }
}
