package umc.spring.study.web.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class StoreRequestDTO {
    @Getter
    public static class ReviewDTO {
        @NotBlank
        String title;
        @NotNull
        Float reward;
        @NotBlank
        String content;
    }

    @Getter
    public static class MissionDTO {
        @NotBlank
        String missionSpec;
        @NotBlank
        LocalDate deadline;
    }
}
