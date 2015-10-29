package org.sistematika.events;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.base.event.LoginEventData;
import org.compiere.model.MOrder;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.osgi.service.event.Event;

public class SistematikaEvents extends AbstractEventHandler {

	CLogger log = CLogger.getCLogger(SistematikaEvents.class);
	
	@Override
	protected void initialize() {
		
		registerEvent(IEventTopics.AFTER_LOGIN);
		
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MOrder.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MOrder.Table_Name);

	}

	@Override
	protected void doHandleEvent(Event event) {
		
		if (event.getTopic().equals(IEventTopics.AFTER_LOGIN))
		{
			LoginEventData data = getEventData(event);
			log.warning("----Login Event Data. Client: " + data.getAD_Client_ID() + 
					", Org: " + data.getAD_Org_ID() + ", Role: " + data.getAD_Role_ID() +
					", User: " + data.getAD_User_ID());
			
		}
		else
		if (event.getTopic().contains(IEventTopics.MODEL_EVENT_PREFIX))
		{
			PO po = getPO(event);
			
			if (po.get_TableName().equals(MOrder.Table_Name))
			{
				if (event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE))
				{
					log.warning("-------MOrder before changes events!");
				}
				else
				if (event.getTopic().equals(IEventTopics.PO_AFTER_CHANGE))
				{
					log.warning("-------MOrder after changes events!");
				
				}
			}
		}
		else
		if (event.getTopic().contains(IEventTopics.DOC_EVENT_PREFIX))
		{
			
		}
	}
}