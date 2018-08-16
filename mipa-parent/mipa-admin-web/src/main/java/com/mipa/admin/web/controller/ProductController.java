package com.mipa.admin.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.mipa.admin.web.constant.AppConstants;
import com.mipa.admin.web.validator.ProductValidator;
import com.mipa.core.data.enums.ProductType;
import com.mipa.core.data.model.ProductDataModel;
import com.mipa.core.product.service.ProductDataService;

@Controller
@RequestMapping("/admin")
public class ProductController {

	private static final Logger LOG = Logger.getLogger(ProductController.class);
	
	@Autowired
	private ProductValidator validator;
	
	@Autowired
	private ProductDataService productDataService;
	
	@RequestMapping(path="/product", method=RequestMethod.GET)
	public String showProducts(@RequestParam(name="deleted", required=false) boolean deleted, Model model) {
		List<ProductDataModel> productList = null;
		if(deleted)
			productList = productDataService.getDeletedProducts(0,  10);
		else
			productList = productDataService.getProducts(0, 10);

		model.addAttribute("productList", productList);
		return "product-list";
	}
	
	@RequestMapping(path="/product/view", method=RequestMethod.GET)
	public String viewProducts(@RequestParam("productId") Integer productId, Model model) {
		ProductDataModel dataModel = productDataService.getProduct(productId);
		model.addAttribute(AppConstants.PRODUCT_FORM_TAG, dataModel);
		return "product-view";
	}
	
	@RequestMapping(path="/product/create", method=RequestMethod.GET)
	public String createProduct(Model model) {
		model.addAttribute(AppConstants.PRODUCT_FORM_TAG, new ProductDataModel());
		return "product-form";
	}
	
	@InitBinder
	public void initBinder(HttpServletRequest request) {
		request.setAttribute("productTypeList", ProductType.values());
	}
	
	@RequestMapping(path="/product", method=RequestMethod.POST)
	public String createProduct(@ModelAttribute(AppConstants.PRODUCT_FORM_TAG) ProductDataModel dataModel, 
			Authentication authentication, BindingResult errors, Model model) {
		LOG.debug("Create Product " + dataModel.getProductId());
		validator.validate(dataModel, errors);
		if(errors.hasErrors()) {
			return "product-form";
		}
		productDataService.createProduct(dataModel);
		return "product-created";
	}
	
	@RequestMapping(path="/product/edit", method=RequestMethod.GET)
	public String editProduct(@RequestParam("productId") Integer productId, Model model) {
		ProductDataModel dataModel = productDataService.getProduct(productId);
		model.addAttribute(AppConstants.PRODUCT_FORM_TAG, dataModel);
		return "product-form";
	}
	
	@RequestMapping(path="/product", method=RequestMethod.PUT)
	public String editProduct(@ModelAttribute(AppConstants.PRODUCT_FORM_TAG) ProductDataModel dataModel, 
			Authentication authentication, BindingResult errors, Model model) {
		LOG.debug("Update Product " + dataModel.getProductId());
		validator.validate(dataModel, errors);
		if(errors.hasErrors()) {
			return "product-form";
		}
		productDataService.updateProduct(dataModel);
		return "product-updated";
	}
	
	@RequestMapping(path="/product", method=RequestMethod.DELETE)
	private RedirectView deleteProduct(@RequestParam("productId") Integer productId, Model model) {
		LOG.debug("Product delete called ID: " + productId);
		String keyCode = "error.product.cannot.deleted";
		if(productDataService.deleteProduct(productId)) {
			keyCode = "product.deleted.successfully";
		}
		return new RedirectView("/admin/product.do?code="+keyCode, true);
	}

}