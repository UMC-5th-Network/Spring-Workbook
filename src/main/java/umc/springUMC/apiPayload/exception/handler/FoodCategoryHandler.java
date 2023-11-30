package umc.springUMC.apiPayload.exception.handler;

import umc.springUMC.apiPayload.code.BaseErrorCode;
import umc.springUMC.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
