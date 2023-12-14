package umc5th.homework.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc5th.homework.apiPayload.ApiResponse;
import umc5th.homework.converter.StoreConverter;
import umc5th.homework.domain.Review;
import umc5th.homework.domain.Store;
import umc5th.homework.service.StoreQueryService;
import umc5th.homework.service.StoreService;
import umc5th.homework.web.dto.StoreDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {
    private final StoreService storeService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/add")
    public ApiResponse<StoreDTO.AddResponseDTO> add(@RequestBody @Valid StoreDTO.AddDTO request){
        Store store = storeService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddDto(store));
    }

    /*
    * Operation은 api에 대한 설명을 넣게 되며 summary, description으로 설명을 적는다
    * ApiResponse로 이 api의 응답을 담게 되며 내부적으로 @ApiReponse로 각각의 응답들을 담게 된다.
    * 에러 상황에 대해서만 content = 를 통해 형태를 알려주고(에러는 코드, 메시자만 중요하지 result는 필요ㅕ 없음)
    * */
    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreDTO.ReviewPreViewListDTO> getReviewList(@PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }
}
