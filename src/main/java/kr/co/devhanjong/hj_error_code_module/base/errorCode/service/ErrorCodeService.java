package kr.co.devhanjong.hj_error_code_module.base.errorCode.service;


import jakarta.annotation.Nullable;
import kr.co.devhanjong.hj_error_code_module.base.errorCode.domain.ErrorCodeBaseDTO;
import kr.co.devhanjong.hj_error_code_module.base.errorCode.domain.ErrorCodeDetailDTO;


public interface ErrorCodeService {


    ErrorCodeBaseDTO getErrorCodeBaseByCode(String code);


    ErrorCodeDetailDTO getErrorCodeDetailByCode(String code);

    ErrorCodeBaseDTO insertErrorCode(ErrorCodeDetailDTO errorCodeDetailDTO);


    ErrorCodeBaseDTO updateErrorCode(ErrorCodeDetailDTO errorCodeDetailDTO);


    ErrorCodeBaseDTO deleteErrorCode(ErrorCodeBaseDTO errorCodeBaseDTO);

    String getFormatErrorCodeMsg(String code, String ...args);
    ErrorCodeBaseDTO getFormatErrorCode(String code, @Nullable String ...args);


}
