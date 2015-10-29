package org.sistematika.callout.factory;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.compiere.model.MOrder;
import org.sistematika.callout.implementation.CalloutOrder;

public class CalloutFactory implements IColumnCalloutFactory {

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName,
			String columnName) {
		
		List<IColumnCallout> list = new ArrayList<IColumnCallout>();
		
		if (tableName.equals(MOrder.Table_Name))
		{
			list.add(new CalloutOrder());
			
		}
		return list.toArray(new IColumnCallout[list.size()]);
		
	}
}
