package umc5th.homework.converter;

import umc5th.homework.domain.Member;
import umc5th.homework.domain.Review;
import umc5th.homework.domain.Store;
import umc5th.homework.web.dto.ReviewDTO;

public class ReviewConverter {
    public static Review toReview(ReviewDTO.AddRequestDTO dto, Member member, Store store){

        Review review = Review.builder()
                .title(dto.getTitle())
                .body(dto.getBody())
                .score(dto.getScore())
                .build();

        review.setMember(member);
        review.setStore(store);

        return  review;
    }
}
