package umc5th.homework.apiPayload.exception.handler;


import umc5th.homework.apiPayload.code.BaseErrorCode;
import umc5th.homework.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode code) {
        super(code);
    }
}
