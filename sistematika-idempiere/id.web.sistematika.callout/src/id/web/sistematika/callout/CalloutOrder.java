package id.web.sistematika.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MOrder;
import org.compiere.util.CLogger;

public class CalloutOrder implements IColumnCallout {

	CLogger log = CLogger.getCLogger(CalloutOrder.class);
			
	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		
		log.warning("Field Name: " + mField.getColumnName());
		if (value != null)
			log.warning("New Value : " + value.toString());
		if (oldValue != null)
			log.warning("Old Value : " + oldValue.toString());
		
		mTab.setValue(MOrder.COLUMNNAME_DocumentNo, "TEST");
		
		return null;
	}

}