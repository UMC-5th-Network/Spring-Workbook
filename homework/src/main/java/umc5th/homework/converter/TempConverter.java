package umc5th.homework.converter;

import umc5th.homework.web.dto.TempResponse;

public class TempConverter {
    public static TempResponse.TempTestDTO toTempTestDTO (){
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!").build();
    }
}
