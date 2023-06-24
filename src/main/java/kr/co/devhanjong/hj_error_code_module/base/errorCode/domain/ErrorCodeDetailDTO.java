package kr.co.devhanjong.hj_error_code_module.base.errorCode.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@RequiredArgsConstructor
@ToString(callSuper = true)
public class ErrorCodeDetailDTO extends ErrorCodeBaseDTO{
    private String memo;
    private String regDate;
    private String modDate;
}
