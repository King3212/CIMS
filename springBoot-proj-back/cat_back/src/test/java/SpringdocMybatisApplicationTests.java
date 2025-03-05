import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.cat_back.cat_back.CatBackApplication;
import com.cat_back.mapper.FooMapper;

@SpringBootTest(classes = CatBackApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringdocMybatisApplicationTests {

    static final Logger logger = LoggerFactory.getLogger(SpringdocMybatisApplicationTests.class);

    @Autowired
    FooMapper fooMapper;

    @Test
    void contextLoads() {
        
        LocalDateTime now = fooMapper.now();
        
        logger.info("NOW={}", now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
    }
}