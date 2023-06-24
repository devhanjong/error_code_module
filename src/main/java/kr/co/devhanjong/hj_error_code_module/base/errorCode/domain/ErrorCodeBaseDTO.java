package kr.co.devhanjong.hj_error_code_module.base.errorCode.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@RequiredArgsConstructor
@SuperBuilder
public class ErrorCodeBaseDTO {

    @NotNull
    @Size(max = 5)
    private String code;

    @NotNull
    @Max(500)
    private Integer httpStatus;

    @NotNull
    private String msg;
}
