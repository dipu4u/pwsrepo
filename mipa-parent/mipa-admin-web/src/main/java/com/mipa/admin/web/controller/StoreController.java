package com.mipa.admin.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mipa.admin.web.constant.AppConstants;
import com.mipa.admin.web.validator.StoreFormValidator;
import com.mipa.core.data.model.AuthUserModel;
import com.mipa.core.data.model.StoreDataModel;
import com.mipa.core.store.service.StoreDataService;

@Controller
@RequestMapping("/admin")
public class StoreController {
	
	private static final Logger LOG = Logger.getLogger(StoreController.class);
	
	@Autowired
	private StoreDataService storeDataService;
	
	@Autowired
	private StoreFormValidator storeFormValidator;

	@RequestMapping(path="/store", method=RequestMethod.GET)
	public String viewStoreList(@RequestParam(name = "deleted", required=false) boolean deleted, Model model) {
		LOG.debug("View Store listing");
		List<StoreDataModel> storeList = null;
		if(deleted)
			storeList = storeDataService.getDeletedStoreList(0, 10);
		else
			storeList = storeDataService.getStoreList(0, 10);

		model.addAttribute("storeList", storeList);
		return "store-list";
	}
	
	@RequestMapping(path="/store/view", method=RequestMethod.GET)
	public String viewStoreDetail(@RequestParam("storeId") Integer storeId, Model model) {
		LOG.debug("View Store details. StoreId " + storeId);
		StoreDataModel dataModel = storeDataService.getStore(storeId);
		model.addAttribute(AppConstants.STORE_FORM_TAG, dataModel);
		return "store-view";
	}
	
	@RequestMapping(path="/store/create", method=RequestMethod.GET)
	public String createStore(Model model) {
		model.addAttribute(AppConstants.STORE_FORM_TAG, new StoreDataModel());
		return "store-form";
	}
	
	@RequestMapping(path="/store", method=RequestMethod.POST)
	public String createStore(@ModelAttribute(AppConstants.STORE_FORM_TAG) StoreDataModel dataModel, 
			Authentication authentication, Model model, BindingResult result) {
		
		storeFormValidator.validate(dataModel, result);
		if(result.hasErrors()) {
			return "store-form";
		}
		LOG.debug("Request received for Create Store " + dataModel.getStoreName());
		AuthUserModel authUserModel = (AuthUserModel) authentication.getPrincipal();
		storeDataService.createStore(dataModel, authUserModel);
		model.addAttribute(AppConstants.UI_MESSAGE_TAG, "store.created.successfully");
		return viewStoreList(false, model);
	}
	
	@RequestMapping(path="/store/edit", method=RequestMethod.GET)
	public String updateStore(@RequestParam("storeId") Integer storeId, Model model) {
		LOG.debug("Store Edit called. " + storeId);
		StoreDataModel dataModel = storeDataService.getStore(storeId);
		model.addAttribute(AppConstants.STORE_FORM_TAG, dataModel);
		return "store-form";
	}
	
	@RequestMapping(path="/store", method=RequestMethod.PUT)
	public String updateStore(@ModelAttribute(AppConstants.STORE_FORM_TAG) StoreDataModel dataModel, 
			Authentication authentication, BindingResult result, Model model) {
		
		storeFormValidator.validate(dataModel, result);
		if(result.hasErrors()) {
			return "store-form";
		}
		LOG.debug("Store Update Method called " + dataModel.getStoreId());
		AuthUserModel authUserModel = (AuthUserModel) authentication.getPrincipal();
		storeDataService.updateStore(dataModel, authUserModel);
		model.addAttribute(AppConstants.UI_MESSAGE_TAG, "store.updated.successfully");
		return viewStoreList(false, model);
	}
	
	@RequestMapping(path="/store", method=RequestMethod.DELETE)
	public String deleteStore(@RequestParam("storeId") Integer storeId, Model model) {
		LOG.debug("Store delete called. ID: " + storeId);
		String keyCode = "store.deleted.successfully";
		if(!storeDataService.deleteStore(storeId)){
			keyCode = "error.store.cannot.deleted";
		}
		model.addAttribute(AppConstants.UI_MESSAGE_TAG, keyCode);
		return viewStoreList(false, model);
	}

}