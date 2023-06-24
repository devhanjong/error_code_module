package kr.co.devhanjong.hj_error_code_module.base.errorCode.service;

import kr.co.devhanjong.hj_error_code_module.TestConfig;
import kr.co.devhanjong.hj_error_code_module.base.errorCode.domain.ErrorCodeBaseDTO;
import kr.co.devhanjong.hj_error_code_module.base.errorCode.domain.ErrorCodeDetailDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest
@Import(TestConfig.class)
public class ErrorCodeServiceImplTest {

    @Autowired
    ErrorCodeService errorCodeService;

    @Test
    @DisplayName("DB 연결테스트 :: 0000코드의 httpStatus 200조회 확인")
    void getErrorCodeBaseByCode() {
        assertThat(errorCodeService.getErrorCodeBaseByCode("0000").getHttpStatus()).isEqualTo(200);
    }


    @Test
    @DisplayName("메시지 포멧 테스트 코드 :: 91001 ")
    void formatErrorCodeTest(){
        // 메시지 내용 :: 포멧 {0} 테스트 {1} {2}
        ErrorCodeBaseDTO formatErrorCode = errorCodeService.getFormatErrorCode("91001", "파람1", "파람2", "파람3");

        System.out.println("formatErrorCode = " + formatErrorCode);

        assertThat(formatErrorCode.getMsg()).isEqualTo("포멧 파람1 테스트 파람2 파람3");
    }

    @Test
    @DisplayName("없는 메시지를 조회하면 RuntimeException 발생한다.")
    void noCodeErrorCodeBaseByCode(){
        assertThatThrownBy(() ->
                errorCodeService.getErrorCodeBaseByCode("951131")
        ).isInstanceOf(RuntimeException.class);
    }


    @Test
    @DisplayName("91002 코드 insert -> update -> delete 진행 메모가 없는 경우")
    void errorCodeInsertUpdateDelete(){
        ErrorCodeDetailDTO errorCodeDetailDTO = ErrorCodeDetailDTO.builder()
                .code("91002")
                .msg("테스트 코드입니다.")
                .httpStatus(200)
                .build();

        // insert
        errorCodeService.insertErrorCode(errorCodeDetailDTO);

        ErrorCodeDetailDTO errorCodeDetailByCode = errorCodeService.getErrorCodeDetailByCode(errorCodeDetailDTO.getCode());

        System.out.println("errorCodeDetailByCode = " + errorCodeDetailByCode);

        // httpStatus update
        errorCodeDetailByCode.setHttpStatus(500);
        errorCodeService.updateErrorCode(errorCodeDetailByCode);

        System.out.println("errorCodeDetailByCode = " + errorCodeDetailByCode);

        // delete code
        errorCodeService.deleteErrorCode(errorCodeDetailByCode);

        assertThatThrownBy(() ->
                errorCodeService.getErrorCodeBaseByCode(errorCodeDetailByCode.getCode())
        ).isInstanceOf(RuntimeException.class);
    }
}
