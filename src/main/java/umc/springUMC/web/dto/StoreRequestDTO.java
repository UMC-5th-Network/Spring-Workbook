package umc.springUMC.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreDto {

        @NotNull
        String name;
        @NotBlank
        Float score;
        @NotNull
        String address;
        @NotNull
        Long mapId;

    }
}
