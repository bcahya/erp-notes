package org.sistematika.modelvalidators;

import org.compiere.model.MClient;
import org.compiere.model.MOrder;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.PO;
import org.compiere.util.CLogger;

public class SistematikaValidator implements ModelValidator {

	CLogger log = CLogger.getCLogger(SistematikaValidator.class);
	
	private int AD_Client_ID = -1;
	@Override
	
	public void initialize(ModelValidationEngine engine, MClient client) {
		
		if (client != null)
			AD_Client_ID = client.getAD_Client_ID();
		
		engine.addModelChange(MOrder.Table_Name, this);
	}

	@Override
	public int getAD_Client_ID() {
		return AD_Client_ID;
		
	}

	@Override
	public String login(int AD_Org_ID, int AD_Role_ID, int AD_User_ID) {
		log.warning("----Log in AD_Org_ID: " + AD_Org_ID + ", Role: " + AD_Role_ID + ", User: " + AD_User_ID);
		return null;
	}

	@Override
	public String modelChange(PO po, int type) throws Exception {
		
		if (po.get_TableName().equals(MOrder.Table_Name))
		{
			if (type == TYPE_CHANGE)
			{
				log.warning(MOrder.Table_Name + ", changes!");
			}
		}
		return null;
		
	}

	@Override
	public String docValidate(PO po, int timing) {
		// TODO Auto-generated method stub
		return null;
	}

}
