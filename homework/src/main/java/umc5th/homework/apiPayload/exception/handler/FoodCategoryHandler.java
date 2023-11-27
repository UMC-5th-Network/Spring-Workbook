package umc5th.homework.apiPayload.exception.handler;

import umc5th.homework.apiPayload.code.BaseErrorCode;
import umc5th.homework.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode code) { super(code);}
}
