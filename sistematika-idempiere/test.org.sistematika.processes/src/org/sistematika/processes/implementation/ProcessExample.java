package org.sistematika.processes.implementation;


public class ProcessExample extends org.compiere.process.SvrProcess {

	@Override
	protected void prepare() {
		log.warning("This is prepare method");
		
	}

	@Override
	protected String doIt() throws Exception {
		log.warning("This is doIt method");
		return "";
		
	}

}