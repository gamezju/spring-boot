/*
 * Copyright 2012-present the original author or authors.
 */

package smoketest.simple;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link SampleSimpleApplication}.
 *
 * @author Dave Syer
 */
@SpringBootTest
class SpringTestSampleSimpleApplicationTests {

	@Autowired
	ApplicationContext ctx;

	@Autowired
	Environment environment;

	@Test
	void smokeRequirementPropertyIsLoaded() {
		assertThat(this.environment.getProperty("smoke.requirement")).isEqualTo("SMOKE-1");
	}

	@Test
	void testContextLoads() {
		assertThat(this.ctx).isNotNull();
		assertThat(this.ctx.containsBean("helloWorldService")).isTrue();
		assertThat(this.ctx.containsBean("sampleSimpleApplication")).isTrue();
	}

}
