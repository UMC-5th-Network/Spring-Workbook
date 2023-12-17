package umc.springUMC.service.StoreService;

import org.springframework.data.domain.Page;
import umc.springUMC.domain.Mission;
import umc.springUMC.domain.Review;
import umc.springUMC.domain.Store;
import umc.springUMC.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.Optional;

public interface StoreService {

    Store addStore(StoreRequestDTO.AddStoreDto request);

    boolean existStore(List<Long> values);

    Optional<Store> findStore(Long id);
    Page<Review> getReviewList(Long StoreId, Integer page); // Page -> paging을 위한 추상화 제공

    Page<Mission> getMissionList(Long storeId, int page);
}
