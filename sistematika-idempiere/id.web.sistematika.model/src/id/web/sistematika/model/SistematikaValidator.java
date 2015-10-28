package id.web.sistematika.model;

import java.util.logging.Level;

import org.compiere.model.MClient;
import org.compiere.model.MOrder;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.PO;
import org.compiere.util.CLogger;

import compiere.model.MyValidator;

public class SistematikaValidator implements ModelValidator {

	public SistematikaValidator() {
		// TODO Auto-generated constructor stub
	}
	
	/**	Logger			*/
	private static CLogger log = CLogger.getCLogger(MyValidator.class);
	/** Client			*/
	private int		m_AD_Client_ID = -1;
	/** User	*/
	private int		m_AD_User_ID = -1;
	/** Role	*/
	private int		m_AD_Role_ID = -1;

	@Override
	public void initialize(ModelValidationEngine engine, MClient client) {
		//client = null for global validator
		if (client != null) {
			m_AD_Client_ID = client.getAD_Client_ID();
			if (log.isLoggable(Level.INFO))
				log.info(client.toString());
		} else {
			if (log.isLoggable(Level.INFO))
				log.info("Initializing global validator: " + this.toString());
		}
		
		engine.addModelChange(MOrder.Table_Name, this);
		
	}

	@Override
	public int getAD_Client_ID() {
		return m_AD_Client_ID;
		
	}

	@Override
	public String login(int AD_Org_ID, int AD_Role_ID, int AD_User_ID) {
		if (log.isLoggable(Level.INFO)) 
			log.info("AD_User_ID=" + AD_User_ID);
		
		m_AD_User_ID = AD_User_ID;
		m_AD_Role_ID = AD_Role_ID;
		
		return null;
		
	}

	@Override
	public String modelChange(PO po, int type) throws Exception {
		
		if (po.get_TableName().equals(MOrder.Table_Name))
		{
			if (type == TYPE_CHANGE)
				System.out.println("Fire type change from model validator....");
			
		}
		
		return null;
	}

	@Override
	public String docValidate(PO po, int timing) {
		// TODO Auto-generated method stub
		return null;
	}

}
