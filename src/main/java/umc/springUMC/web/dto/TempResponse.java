package umc.springUMC.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TempResponse {

    /**
     * DTO - 큰 묶음으로 class 생성 ex) MemberDTO 등
     *     - 내부적으로 static class 생성
     *     - 범용적인 DTO 사용 가능해짐.
     */

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempTestDTO {
        String testString;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempExceptionDTO {
        Integer flag;
    }
}
