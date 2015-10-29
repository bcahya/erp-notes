package org.sistematika.factory;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.MOrder;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.sistematika.model.MOrder_SIS;

public class SISModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		
		if (tableName.equals(MOrder.Table_Name))
			return MOrder_SIS.class;

		return null;
		
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		
		if (tableName.equals(MOrder.Table_Name))
			return new MOrder_SIS(Env.getCtx(), Record_ID, trxName);
		
		return null;
	
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if (tableName.equals(MOrder.Table_Name))
			return new MOrder_SIS(Env.getCtx(), rs, trxName);
		
		return null;
		
	}
}