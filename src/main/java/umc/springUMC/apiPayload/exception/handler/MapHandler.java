package umc.springUMC.apiPayload.exception.handler;

import umc.springUMC.apiPayload.code.BaseErrorCode;
import umc.springUMC.apiPayload.exception.GeneralException;

public class MapHandler extends GeneralException {
    public MapHandler(BaseErrorCode errorCode) { super(errorCode); }
}
