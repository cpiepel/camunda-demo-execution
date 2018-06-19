package de.camunda.sample.execution;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class Service {
    public void doIt(DelegateExecution execution) {
        System.out.println("\nExecution: " + execution);
        System.out.println("ProcessBusinessKey: " + execution.getProcessBusinessKey());
        System.out.println("BusinessKey: " + execution.getBusinessKey());
    }

}