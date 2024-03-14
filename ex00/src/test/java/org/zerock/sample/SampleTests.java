package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {

//	@Log4j => private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(SampleTests.class.getName());
//	의 log 객체를 선언하는 기능이 실현됨.

	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant;

	@Test
	public void testExist() {
		assertNotNull(restaurant);

		log.info(restaurant);
		log.info("------------------------");
		log.info(restaurant.getChef());
	}
}
