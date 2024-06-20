package umc.spring.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

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
        String title;
        @NotBlank
        String content;
    }
}
