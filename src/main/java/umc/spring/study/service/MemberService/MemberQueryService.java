package umc.spring.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);

    Page<Review> getReviewList (Long memberId, Integer page);

    Page<MemberMission> getMissionList (Long memberId, Integer page);
}
