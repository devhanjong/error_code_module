package kr.co.devhanjong.hj_error_code_module.base.errorCode.service;

import kr.co.devhanjong.hj_error_code_module.base.errorCode.domain.ErrorCodeBaseDTO;
import kr.co.devhanjong.hj_error_code_module.base.errorCode.domain.ErrorCodeDetailDTO;
import kr.co.devhanjong.hj_error_code_module.base.errorCode.repository.ErrorCodeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ErrorCodeServiceImpl implements ErrorCodeService{

    @Autowired
    private final ErrorCodeMapper errorCodeMapper;

    @Override
    @Cacheable(value = "errorCode" , key = "{#code}", cacheManager = "commonModuleCacheManager")
    public ErrorCodeBaseDTO getErrorCodeBaseByCode(String code) {
        System.out.println("no cache");
        return Optional.ofNullable(errorCodeMapper.getErrorCodeBaseByCode(code)).orElseThrow(RuntimeException::new);
    }

    @Override
    public ErrorCodeDetailDTO getErrorCodeDetailByCode(String code) {
        errorCodeMapper.getErrorCodeDetailByCode(code);
        return Optional.ofNullable(errorCodeMapper.getErrorCodeDetailByCode(code)).orElseThrow(RuntimeException::new);
    }

    @Override
    @CachePut(value = "errorCode" , key = "{#errorCodeDetailDTO.code}", cacheManager = "commonModuleCacheManager")
    public ErrorCodeBaseDTO insertErrorCode(ErrorCodeDetailDTO errorCodeDetailDTO) {
        errorCodeMapper.insertErrorCode(errorCodeDetailDTO);
        return ErrorCodeBaseDTO.builder()
                .code(errorCodeDetailDTO.getCode())
                .msg(errorCodeDetailDTO.getMsg())
                .httpStatus(errorCodeDetailDTO.getHttpStatus())
                .build();
    }

    @Override
    @CachePut(value = "errorCode" , key = "{#errorCodeDetailDTO.code}", cacheManager = "commonModuleCacheManager")
    public ErrorCodeBaseDTO updateErrorCode(ErrorCodeDetailDTO errorCodeDetailDTO) {
        errorCodeMapper.updateErrorCode(errorCodeDetailDTO);
        return ErrorCodeBaseDTO.builder()
                .code(errorCodeDetailDTO.getCode())
                .msg(errorCodeDetailDTO.getMsg())
                .httpStatus(errorCodeDetailDTO.getHttpStatus())
                .build();
    }

    @Override
    @CacheEvict(value = "errorCode" , key = "{#errorCodeBaseDTO.code}", cacheManager = "commonModuleCacheManager")
    public ErrorCodeBaseDTO deleteErrorCode(ErrorCodeBaseDTO errorCodeBaseDTO) {
        errorCodeMapper.deleteErrorCode(errorCodeBaseDTO);
        return errorCodeBaseDTO;
    }


    @Override
    public String getFormatErrorCodeMsg(String code, String ...args) {
        ErrorCodeBaseDTO errorCodeBaseDTO = getErrorCodeBaseByCode(code);

        if (args == null || args.length == 0) return errorCodeBaseDTO.getMsg();

        return MessageFormat.format(errorCodeBaseDTO.getMsg(), (Object[]) args);
    }

    @Override
    public ErrorCodeBaseDTO getFormatErrorCode(String code, String ...args) {
        ErrorCodeBaseDTO errorCodeBaseDTO = getErrorCodeBaseByCode(code);

        if (args == null || args.length == 0) return errorCodeBaseDTO;

        errorCodeBaseDTO.setMsg(MessageFormat.format(errorCodeBaseDTO.getMsg(), (Object[]) args));
        return errorCodeBaseDTO;
    }
}
