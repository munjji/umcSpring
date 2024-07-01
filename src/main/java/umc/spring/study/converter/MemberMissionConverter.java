package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.web.dto.MemberMissionResponseDTO;
import umc.spring.study.web.dto.MemberRequestDTO;
import umc.spring.study.web.dto.MemberResponseDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

import java.util.List;

@Component
public class MemberMissionConverter {
    public static MemberMission toUpdateMission(MemberRequestDTO.MissionUpdateDTO request, Member member, Mission mission) {
        MissionStatus missionStatus = null;

        switch (request.getMissionStatus()) {
            case "진행 중":
                missionStatus = MissionStatus.CHALLENGING;
                break;
            case "미션 완료":
                missionStatus = MissionStatus.COMPLETE;
                break;
        }

        return MemberMission.builder()
                .status(missionStatus)
                .member(member)
                .mission(mission)
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionDTO toUpdateMissionResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionDTO.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .build();
    }
}
