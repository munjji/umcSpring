package umc.spring.study.converter;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.web.dto.StoreRequestDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static Review toReview(StoreRequestDTO.ReviewDTO request) {
        return Review.builder().title(request.getTitle()).reward(request.getReward()).content(request.getContent()).build();
    }

    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(StoreRequestDTO.MissionDTO request) {
        return Mission.builder().deadline(request.getDeadline()).missionSpec(request.getMissionSpec()).build();
    }

    public static StoreResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission) {
        return StoreResponseDTO.CreateMissionResultDTO.builder().missionId(mission.getId()).createdAt(mission.getCreatedAt()).build();
    }
}
