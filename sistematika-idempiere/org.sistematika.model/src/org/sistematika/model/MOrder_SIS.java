package org.sistematika.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MOrder_SIS extends X_C_Order {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9003642358680952165L;

	public MOrder_SIS(Properties ctx, int C_Order_ID, String trxName) {
		super(ctx, C_Order_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MOrder_SIS(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord)
	{
		log.warning("---------before save---------");
		return true;
	}	//	beforeSave

	@Override
	protected boolean beforeDelete ()
	{
		log.warning("---------before delete-------");
		return true;
	} 	//	beforeDelete

}