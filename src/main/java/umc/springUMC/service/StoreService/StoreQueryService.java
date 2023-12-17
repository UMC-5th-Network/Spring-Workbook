package umc.springUMC.service.StoreService;

import org.springframework.data.domain.Page;
import umc.springUMC.domain.Review;
import umc.springUMC.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    Page<Review> getReviewList(Long StoreId, Integer page); // Page -> paging을 위한 추상화 제공
}
