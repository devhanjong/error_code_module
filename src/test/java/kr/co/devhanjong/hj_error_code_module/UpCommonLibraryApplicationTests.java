package kr.co.devhanjong.hj_error_code_module;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = UpCommonLibraryApplicationTests.class)
class UpCommonLibraryApplicationTests {

    @Test
    @DisplayName("@SpringBootApplication이 없어도 " +
            "테스트 코드에서 스프링 부트 테스트가 되는지 확인한다.")
    void helloWorld() {
        Assertions.assertThat("Hello World!!").isEqualTo("Hello World!!");
    }
}
