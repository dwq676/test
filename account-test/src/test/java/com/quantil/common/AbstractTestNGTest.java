package com.quantil.common;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * AbstractTestNGTest
 *
 * @author <a href="mailto:dwq676@126.com">daiwenqing</a>
 * @date 2017/6/15
 */
@ContextConfiguration({"classpath:spring.xml","classpath:shiro.xml"})
public abstract class AbstractTestNGTest extends AbstractTestNGSpringContextTests {

}
