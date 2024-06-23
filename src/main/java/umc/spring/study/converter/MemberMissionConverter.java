package umc.spring.study.converter;

import org.springframework.stereotype.Component;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.web.dto.MemberMissionRequestDTO;

@Component
public class MemberMissionConverter {
    public MemberMission toEntity(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }

    public MemberMissionRequestDTO.MemberMissionDTO toDto(MemberMission memberMission) {
        return MemberMissionRequestDTO.MemberMissionDTO.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .build();
    }
}
