package id.web.sistematika.model;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.MOrder;
import org.compiere.model.PO;
import org.compiere.util.Env;

public class SistematikaModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		
		if (tableName.equals(MOrder.Table_Name))
			return MOrderExt.class;
		else
			return null;
		
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		
		if (tableName.equals(MOrder.Table_Name))
			return new MOrderExt(Env.getCtx(), Record_ID, trxName);
		else
			return null;
		
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		
		if (tableName.equals(MOrder.Table_Name))
			return new MOrderExt(Env.getCtx(), rs, trxName);
		else
			return null;
		
	}

}
