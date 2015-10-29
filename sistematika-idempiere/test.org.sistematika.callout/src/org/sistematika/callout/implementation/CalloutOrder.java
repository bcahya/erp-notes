package org.sistematika.callout.implementation;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MOrder;

public class CalloutOrder implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		
		if (mField.getColumnName().equals(MOrder.COLUMNNAME_Description))
		{
			mTab.setValue(MOrder.COLUMNNAME_POReference, "from description");
			
		}
		
		if (mField.getColumnName().equals(MOrder.COLUMNNAME_AD_Org_ID))
		{
			mTab.setValue(MOrder.COLUMNNAME_POReference, "from organization");
			
		}
		
		return null;
	}

}
