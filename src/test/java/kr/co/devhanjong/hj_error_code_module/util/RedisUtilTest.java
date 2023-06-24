//package kr.co.devhanjong.hj_error_code_module.util;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Map;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//class RedisUtilTest {
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    @BeforeEach
//    void before(){
//    }
//
//    @Test
//    @DisplayName("redis TEST_MAP 호출시 map을 리턴한다.")
//    void getRedisDataMap() {
//        Map<String, Object> map = redisUtil.getRedisDataMap("TEST_MAP");
//        assertThat(map).isNotNull();
//    }
//
//    @Test
//    @DisplayName("redis TEST 호출시 VALUE를 리턴해야한다.")
//    void getRedisDataString() {
//        String value = redisUtil.getRedisDataString("TEST");
//        System.out.println("value = " + value);
//        assertThat(value).isEqualTo("VALUE");
//    }
//
//
//    @Test
//    @DisplayName("redis TEST_LIST 호출시 list를 리턴한다.")
//    void getRedisDataList() {
//        Map<String, Object> map = redisUtil.getRedisDataMap("TEST_LIST");
//        assertThat(map).isNotNull();
//    }
//
//    @Test
//    void setRedisData() {
//    }
//
//    @Test
//    void removeRedisData() {
//    }
//}
