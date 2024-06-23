package umc.spring.study.service.StoreService;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request);
    Mission createMission (Long storeId, StoreRequestDTO.MissionDTO request);
}
