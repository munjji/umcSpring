package umc.spring.study.converter;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.web.dto.StoreRequestDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static Review toReview(StoreRequestDTO.ReviewDTO request) {
        return Review.builder()
                .title(request.getTitle())
                .reward(request.getReward())
                .content(request.getContent())
                .build();
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

    public static StoreResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review) {
        return StoreResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getReward())
                .createdAt(review.getCreatedAt())
                .body(review.getContent())
                .build();
    }

    public static StoreResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList) {
        List<StoreResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreviewDTO).toList();

        return StoreResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewList(reviewPreviewDTOList)
                .build();
    }
}
