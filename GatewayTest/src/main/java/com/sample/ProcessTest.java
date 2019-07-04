package com.sample;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.jbpm.runtime.manager.impl.RuntimeEnvironmentBuilder;
import org.jbpm.runtime.manager.impl.jpa.EntityManagerFactoryManager;
import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeEnvironment;
import org.kie.api.runtime.manager.RuntimeManagerFactory;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.TaskSummary;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
 
 public class ProcessTest extends JbpmJUnitBaseTestCase {
 
    private KieSession ksession;
    private ProcessInstance processInstance;
    private TaskService taskService;
    private RuntimeEngine runtimeEngine;
    private EntityManagerFactory emf;
 
    public ProcessTest() {
        super(true, true);
    }
 
    @Before
    public void initialise() {
        emf = EntityManagerFactoryManager.get().getOrCreate("org.jbpm.persistence.jpa");
        
    }
 
    /*@After
    public void dispose() {
        ksession.dispose();
        manager.disposeRuntimeEngine(runtimeEngine);
        manager.close();
    }*/
 
    @Test
    public void run() {
     
        RuntimeEnvironment environment = RuntimeEnvironmentBuilder.Factory.get().newDefaultInMemoryBuilder()
        		.userGroupCallback(userGroupCallback).entityManagerFactory(emf)
                 
                .addAsset(ResourceFactory.newClassPathResource("com/sample/sample.bpmn"),ResourceType.BPMN2)                                 
                .get();
       
        manager = RuntimeManagerFactory.Factory.get().newPerProcessInstanceRuntimeManager(environment);
        runtimeEngine = manager.getRuntimeEngine(ProcessInstanceIdContext.get());        KieSession ksession = runtimeEngine.getKieSession();
    
        processInstance = ksession.startProcess("com.sample.bpmn.humantask");
       
        // Code for human task execution 
        
        taskService = runtimeEngine.getTaskService(); 
        List<TaskSummary> tasklist = taskService.getTasksByStatusByProcessInstanceId(
        		processInstance.getId(),
        		new ArrayList<Status>(),
        		"en-UK");   
       taskService.start(tasklist.get(0).getId(), "saahamad");
       taskService.complete(tasklist.get(0).getId(), "saahamad", null);           
          
    }  
}