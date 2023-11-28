package umc5th.homework.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc5th.homework.apiPayload.ApiResponse;
import umc5th.homework.converter.StoreConverter;
import umc5th.homework.domain.Store;
import umc5th.homework.service.StoreService;
import umc5th.homework.web.dto.StoreDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {
    private final StoreService storeService;

    @PostMapping("/add")
    public ApiResponse<StoreDTO.AddResponseDTO> add(@RequestBody @Valid StoreDTO.AddDTO request){
        Store store = storeService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddDto(store));
    }
}
