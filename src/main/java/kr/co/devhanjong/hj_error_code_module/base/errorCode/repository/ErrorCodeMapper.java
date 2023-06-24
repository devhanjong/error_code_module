package kr.co.devhanjong.hj_error_code_module.base.errorCode.repository;

import kr.co.devhanjong.hj_error_code_module.base.errorCode.domain.ErrorCodeBaseDTO;
import kr.co.devhanjong.hj_error_code_module.base.errorCode.domain.ErrorCodeDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ErrorCodeMapper {
    public ErrorCodeBaseDTO getErrorCodeBaseByCode(String code);

    public ErrorCodeDetailDTO getErrorCodeDetailByCode(String code);

    public int insertErrorCode(ErrorCodeDetailDTO errorCodeDetailDTO);

    public int updateErrorCode(ErrorCodeDetailDTO errorCodeDetailDTO);

    public int deleteErrorCode(ErrorCodeBaseDTO errorCodeBaseDTO);
}
