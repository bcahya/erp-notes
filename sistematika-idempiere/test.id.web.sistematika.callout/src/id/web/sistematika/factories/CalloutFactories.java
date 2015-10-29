package id.web.sistematika.factories;

import id.web.sistematika.callout.CalloutOrder;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.compiere.model.MOrder;

public class CalloutFactories implements IColumnCalloutFactory {

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName,
			String columnName) {
		
		List<IColumnCallout> list = new ArrayList<IColumnCallout>();
		
		if (tableName.equals(MOrder.Table_Name) && columnName.equals(MOrder.COLUMNNAME_Description))
			list.add(new CalloutOrder());
		
		if (tableName.equals(MOrder.Table_Name) && columnName.equals(MOrder.COLUMNNAME_AD_Org_ID))
			list.add(new CalloutOrder()); 
		
		return list.toArray(new IColumnCallout[list.size()]);
		//return list != null ? list.toArray(new IColumnCallout[0]) : new IColumnCallout[0] ;
	}

}