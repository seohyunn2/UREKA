package com.uplus.ureka;

import com.uplus.ureka.member.model.dao.MemberDao;
import com.uplus.ureka.member.model.dto.Member;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest (
            properties = {"spring.config.location=classpath:application.properties"}
)
@ComponentScan(basePackages = {"com.uplus.ureka"})
class SpringBootTestApplicationMemberTests { // 얘는 생성자를 만들지 X -> 필요한 건 @Autowired 통해서
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataSource ds;

    @Autowired
    private MemberDao memDao;

    @Test
    public void dsTest() {
        // null인지 체크하는 단정 함수
        assertNotNull(ds);
    }

    @Test
    public void memDaoTest() {
        // null인지 체크하는 단정 함수
        assertNotNull(memDao);
    }

    @Test
    public void searchTest() throws Exception {
        Member member = memDao.search("eureka");
        assertNotNull(member);
        log.debug("member: {}", member);
    }

    @Test
    public void registTest() throws Exception {
        Member member = new Member();
        member.setId("lshlsh");
        member.setPassword("1234");
        member.setName("이서현");
        memDao.regist(member);

        assertNotNull(memDao.search("lshlsh"));
    }

}
