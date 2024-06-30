package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Review;
import umc.spring.study.web.dto.MemberResponseDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

import java.util.List;

public class MemberReviewConverter {

    public static MemberResponseDTO.ReviewsResultDTO reviewDTO(Review review) {
        return MemberResponseDTO.ReviewsResultDTO.builder()
                .name(review.getMember().getName())
                .reward(review.getReward())
                .createdAt(review.getCreatedAt())
                .content(review.getContent())
                .build();
    }

    public static MemberResponseDTO.ReviewsResultListDTO reviewListDTO (Page<Review> reviewList) {
        List<MemberResponseDTO.ReviewsResultDTO> reviewDTOList = reviewList.stream()
                .map(MemberReviewConverter::reviewDTO).toList();

        return MemberResponseDTO.ReviewsResultListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewDTOList.size())
                .reviewList(reviewDTOList)
                .build();
    }

}
