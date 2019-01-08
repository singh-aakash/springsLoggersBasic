package com.cg.app.service.Calculator;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class Operation {
	
	public Integer add(int num1, int num2) {
		Logger logger = Logger.getLogger(Operation.class.getName());
		return num1 + num2;
		//logger.info("Sum is" + sum);
	}

}
