package de.camunda.sample.execution;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.runtimeService;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;

/*@RunWith(SpringJUnit4ClassRunner.class)*/
@ContextConfiguration(classes = ParallelGatewayProzessTestConfig.class)
@Deployment(resources = {"model/BugBusinessKeyNotFoundAfterParallelGateway.bpmn"})
public final class ParallelGatewayProzessTest {

	private static String PROCESS_DEF_KEY = "parallelGatewayTestId";

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Rule
	public ProcessEngineRule processEngineRule = new ProcessEngineRule();



	@Test

	public void testParallelGateway() throws Exception {
		logger.info("## starte Test  ## ");

		ProcessInstance processInstance = runtimeService().startProcessInstanceByKey(PROCESS_DEF_KEY, "0815");


		assertThat(processInstance).isActive();

		claim(task("UserTaskId2"), "usrID");
		complete(task("UserTaskId2"));

		assertThat(processInstance).isEnded();


	}
	


}
