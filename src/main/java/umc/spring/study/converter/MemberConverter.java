package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.enums.Gender;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.web.dto.MemberRequestDTO;
import umc.spring.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO (Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request) {
        Gender gender = null;
        switch (request.getGender()) {
            case "여":
                gender = Gender.FEMALE;
                break;
            case "남":
                gender = Gender.MALE;
                break;
            case "선택 안 함":
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MissionsResultDTO missionsResultDTO (MemberMission memberMission) {
        String status = null;

        switch (memberMission.getStatus()) {
            case CHALLENGING:
                status = "진행 중";
                break;
            case COMPLETE:
                status = "미션 완료";
                break;
        }

        return MemberResponseDTO.MissionsResultDTO.builder()
                .name(memberMission.getMission().getStore().getName())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .status(status)
                .build();
    }

    public static MemberResponseDTO.MissionsResultListDTO missionsResultListDTO (Page<MemberMission> memberMissionList) {
        List<MemberResponseDTO.MissionsResultDTO> missionDTOList = memberMissionList.stream()
                .map(MemberConverter::missionsResultDTO).toList();

        return MemberResponseDTO.MissionsResultListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(missionDTOList.size())
                .missionList(missionDTOList)
                .build();
    }
}
