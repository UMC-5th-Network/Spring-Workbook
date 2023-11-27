package umc5th.homework.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc5th.homework.apiPayload.ApiResponse;
import umc5th.homework.web.dto.MemberRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberRequestDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        return null;
    }
}
