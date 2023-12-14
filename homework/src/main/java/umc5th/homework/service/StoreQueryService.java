package umc5th.homework.service;

import org.springframework.data.domain.Page;
import umc5th.homework.domain.Review;
import umc5th.homework.domain.Store;

import java.util.Optional;

//Spring Data JPA에서 제공하는 Paging 관련 추상화 찾아보기!
public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    Page<Review> getReviewListByStore(Long storeId, Integer page);
    Page<Review> getReviewListByMember(Long storeId, Integer page);
}
