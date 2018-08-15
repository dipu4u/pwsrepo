package com.mipa.admin.web.validator;

import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mipa.core.data.model.ProductDataModel;
import com.mipa.core.util.CommonUtility;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductDataModel.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductDataModel model = (ProductDataModel) target;
		if(CommonUtility.isEmpty(model.getProductName())) {
			errors.rejectValue("productName", "enter.valid");
		}
		if(Objects.isNull(model.getProductType())) {
			errors.rejectValue("productType", "select.valid");
		}
		if(CommonUtility.isEmpty(model.getCategory())) {
			errors.rejectValue("category", "enter.valid");
		}
	}

}