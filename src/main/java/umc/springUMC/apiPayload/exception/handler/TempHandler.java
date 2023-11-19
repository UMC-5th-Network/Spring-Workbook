package umc.springUMC.apiPayload.exception.handler;

import umc.springUMC.apiPayload.code.BaseErrorCode;
import umc.springUMC.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
