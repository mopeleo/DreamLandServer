package com.dl.server.service.test.sys;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dl.server.dto.sys.SysCustDTO;
import com.dl.server.service.sys.SysCustService;

public class SysCustServiceTest {

    private SysCustService custService;
    
    @Before
    public void before() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:spring/*.xml");
        custService = (SysCustService) ac.getBean("sysCustServiceImpl");
    }

    @Test
    public void testSaveCust() {
        SysCustDTO user = new SysCustDTO();
        user.setCustno(111);
        user.setLoginid("hyh");
        user.setLoginpwd("123");
        user.setNickname("mopeleo");
        user.setIdtype("1");
        user.setMobile("1333");
        custService.insert(user);
        
        SysCustDTO sys = custService.getById(111).getResult();
        System.out.println(sys.getNickname());
    }
}
