package umc5th.homework.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc5th.homework.apiPayload.code.status.ErrorStatus;
import umc5th.homework.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{
    @Override
    public void CheckFlag(Integer flag) {
        if(flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
