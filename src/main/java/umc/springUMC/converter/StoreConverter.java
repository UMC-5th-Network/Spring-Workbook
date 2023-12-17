package umc.springUMC.converter;

import org.springframework.data.domain.Page;
import umc.springUMC.domain.Map;
import umc.springUMC.domain.Member;
import umc.springUMC.domain.Review;
import umc.springUMC.domain.Store;
import umc.springUMC.web.dto.ReviewRequestDTO;
import umc.springUMC.web.dto.StoreRequestDTO;
import umc.springUMC.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    // Store entity 받아서 ResponseDTO로 만듦
    public static StoreResponseDTO.AddStoreResultDTO toAddStoreResultDTO(Store store) {
        return StoreResponseDTO.AddStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // RequestDTO 받아서 Store entity 생성
    public static Store toStore(StoreRequestDTO.AddStoreDto request, Map map) {
        Store store = Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .build();

        store.setMap(map);

        return store;
    }

    public static Review toReview (ReviewRequestDTO.WriteReviewDTO request, Member member, Store store) {

        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
