package org.sistematika.factory;

import org.adempiere.base.IModelValidatorFactory;
import org.compiere.model.ModelValidator;
import org.sistematika.modelvalidators.SistematikaValidator;

public class SISModelValidatorFactory implements IModelValidatorFactory {

	@Override
	public ModelValidator newModelValidatorInstance(String className) {

		if (className.equalsIgnoreCase("org.sistematika.modelvalidators.SistematikaValidator"))
			return new SistematikaValidator();
		
		return null;
	}

}