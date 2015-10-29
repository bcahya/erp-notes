package id.web.sistematika.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MOrder;
import org.compiere.model.MProject;

public class MOrderExt extends MOrder {

	/**
	 * 
	 */
	private static final long serialVersionUID = -565193199865780798L;

	public MOrderExt(Properties ctx, int C_Order_ID, String trxName) {
		super(ctx, C_Order_ID, trxName);
		
	}

	public MOrderExt(MProject project, boolean IsSOTrx, String DocSubTypeSO) {
		super(project, IsSOTrx, DocSubTypeSO);
		
	}

	public MOrderExt(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		
	}
	
	@Override
	public boolean beforeSave(boolean newRecord)
	{
		System.out.println("Sistematika model extentions from doc no: " + getDocumentNo());
		return super.beforeSave(newRecord);
	}

}
