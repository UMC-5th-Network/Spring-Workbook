package umc5th.homework.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
DTO들은 큰 묶음으로(멤버 관려 DTO 등등) 클래스를 만들고
내부적으로 static 클래스를 만들어서 사용하는 것이 좋다
* */
public class TempResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempTestDTO{
        String testString;
    }
}
