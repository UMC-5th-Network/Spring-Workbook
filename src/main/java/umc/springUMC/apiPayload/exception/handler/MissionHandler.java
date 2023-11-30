package umc.springUMC.apiPayload.exception.handler;

import umc.springUMC.apiPayload.code.BaseErrorCode;
import umc.springUMC.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) { super(errorCode); }
}
