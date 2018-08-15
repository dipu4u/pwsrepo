package com.mipa.admin.web.constant;

import java.util.HashMap;
import java.util.Map;

import com.mipa.core.data.enums.UserType;
import com.mipa.core.data.model.AuthUserModel;

public class AppConstants {

	
public static final String ROLE_PREFIX = "ROLE_";
	
	public static final String HASH_ALGORITHM = "MD5";
	
	/* password1 */
	public static final String HASH_PASSWORD = "7C6A180B36896A0A8C02787EEAFB0E4C";
	
	public static final Map<String, AuthUserModel> APP_USERS = new HashMap<String, AuthUserModel>(2);
	
	static {
		APP_USERS.put("pws-admin", new AuthUserModel(10,  "pws-admin", UserType.SUPERADMIN));
		APP_USERS.put("store-admin", new AuthUserModel(20,  "store-admin", UserType.ADMIN));
	}
	
	public static final String UI_MESSAGE_TAG = "messageTag";
	public static final String STORE_FORM_TAG = "storeDataModel";
	public static final String PRODUCT_FORM_TAG = "productDataModel";
}