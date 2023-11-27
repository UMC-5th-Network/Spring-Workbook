package umc.springUMC.apiPayload.exception.handler;

import umc.springUMC.apiPayload.code.BaseErrorCode;
import umc.springUMC.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) { super(errorCode); }
}
