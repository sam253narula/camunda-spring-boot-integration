package org.camunda.bpm.spring.boot.example.webapp.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ChargeCreditCardDelegate implements JavaDelegate {
	 private static final Logger LOGGER = LoggerFactory.getLogger(ChargeCreditCardDelegate.class);
	  @Override
	  public void execute(DelegateExecution execution) throws Exception {
	    LOGGER.info("Amount charged {}", execution.getVariable("amount"));
	    if(execution.getVariable("item")!=null) {
	    	 LOGGER.info("Amount charged {}", execution.getVariable("item"));
	    }
	  }
}
