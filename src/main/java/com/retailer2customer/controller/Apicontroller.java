package com.retailer2customer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.retailer2customer.errorhandler.ArgumentNotValidException;
import com.retailer2customer.model.CustomerRewardPoints;
import com.retailer2customer.model.UserRequest;
import com.retailer2customer.service.RewardPointsService;

@RestController
public class Apicontroller {
	
	private static final String STRING = "String";
	
	
	@Autowired
	private RewardPointsService rewardpointsservice;
	
	
	
	
	
	/**
	 * GET request to calculate rewards for given amount spent
	 * 
	 * @param userrequest
	 * @throws MissingServletRequestParameterException
	 * 
	 */
	
	@GetMapping(value="/getrewardpoints")
	@ResponseBody
	public long getMonthlyResponse(@RequestParam("amountspent") long amountspent) throws MissingServletRequestParameterException{

		long rewards = 0L;

		if(amountspent>=0){
			rewards=rewardpointsservice.calculate(amountspent);
		}
		else{
			throw new ArgumentNotValidException("Amountspent cannot be negative");
		}

		return rewards;

	}
	
	
	
		
	/**
	 * POST request to fetch the customer details from H2 database and return calculated rewards of the customer
	 * 
	 * @param userrequest
	 * @throws MissingServletRequestParameterException
	 * @throws ArgumentNotValidException
	 */
	
	@PostMapping(value="/getrewardpointsofcustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerRewardPoints> getrewardpointsofcustomer(@Valid @RequestBody UserRequest userRequest, Errors errors) throws MissingServletRequestParameterException, ArgumentNotValidException  {

		// Validate input contract
		validateRequest(userRequest);
		
		CustomerRewardPoints rewardpoints=rewardpointsservice.fetchCustomerById(userRequest);

		return  new ResponseEntity<>(rewardpoints, HttpStatus.OK);

	}


	
	/**
	 * Validate the input request parameters
	 * 
	 * @param userrequest
	 * @throws MissingServletRequestParameterException
	 * @throws ArgumentNotValidException
	 */
	
	private void validateRequest(UserRequest userRequest) throws ArgumentNotValidException,MissingServletRequestParameterException{
		
		if (StringUtils.isBlank(userRequest.getUserid())) {
			throw new MissingServletRequestParameterException("userid is missing", STRING);
		}
		
		if (Integer.valueOf(userRequest.getUserid())<=0) {
			throw new ArgumentNotValidException("userid cannot be negative or zero");
		}
	}

}

