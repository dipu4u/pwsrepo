package com.mipa.admin.web.validator;

import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mipa.core.data.model.StoreDataModel;
import com.mipa.core.util.CommonUtility;

@Component
public class StoreFormValidator implements Validator {
		
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == StoreDataModel.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		StoreDataModel model = (StoreDataModel) target;
		if(CommonUtility.isEmpty(model.getStoreName()) || model.getStoreName().length() > 20) {
			errors.rejectValue("storeName", "enter.valid"); 
		}
		if(Objects.isNull(model.getStoreType())) {
			errors.rejectValue("storeType", "select.valid"); 
		}
		if(CommonUtility.isEmpty(model.getBranch()) || model.getBranch().length() > 30) {
			errors.rejectValue("branch", "enter.valid");
		}
		if(CommonUtility.isEmpty(model.getAddress()) || model.getAddress().length() > 100) {
			errors.rejectValue("address", "enter.valid");
		}
		if(CommonUtility.isEmpty(model.getPincode()) 
				|| model.getPincode().length() < 2 || model.getPincode().length() > 10) {
			errors.rejectValue("pincode", "enter.valid");
		}
		if(CommonUtility.isEmpty(model.getLatitude()) 
				|| model.getLatitude().length() < 5 || model.getLatitude().length() > 50) {
			errors.rejectValue("latitude", "enter.valid");
		}
		if(CommonUtility.isEmpty(model.getLongitude()) 
				|| model.getLongitude().length() < 5 || model.getLongitude().length() > 50) {
			errors.rejectValue("longitude", "enter.valid");
		}
	}

}