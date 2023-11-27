package umc.springUMC.apiPayload.exception.handler;

import umc.springUMC.apiPayload.code.BaseErrorCode;
import umc.springUMC.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {

    public StoreHandler(BaseErrorCode errorCode) { super(errorCode); }
}
