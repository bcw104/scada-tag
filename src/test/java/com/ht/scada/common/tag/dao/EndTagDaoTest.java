package com.ht.scada.common.tag.dao;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 薄成文 13-5-24 下午1:00
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class EndTagDaoTest extends AbstractTestNGSpringContextTests {
    @Test
    public void findByUserIdAndEndTagTypeTest(){
        System.out.println("findByUserIdAndEndTagTypeTest");
    }
}
