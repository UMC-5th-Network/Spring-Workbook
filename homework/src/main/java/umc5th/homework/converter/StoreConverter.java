package umc5th.homework.converter;

import org.springframework.data.domain.Page;
import umc5th.homework.domain.Region;
import umc5th.homework.domain.Review;
import umc5th.homework.domain.Store;
import umc5th.homework.web.dto.StoreDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreDTO.AddResponseDTO toAddDto(Store store){
        return StoreDTO.AddResponseDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreDTO.AddDTO addDTO, Region region){
        Store store = Store.builder()
                .name(addDTO.getName())
                .score(addDTO.getScore())
                .address(addDTO.getAddress())
                .build();

        store.setRegion(region);

        return store;
    }

    public static StoreDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static StoreDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
