package org.sistematika.processes.factories;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;
import org.sistematika.processes.implementation.ProcessExample;

public class SISProcessFactory implements IProcessFactory {

	@Override
	public ProcessCall newProcessInstance(String className) {
		
		if (className.equals("org.sistematika.processes.implementation.ProcessExample"))
			return new ProcessExample();

		return null;
	}

}