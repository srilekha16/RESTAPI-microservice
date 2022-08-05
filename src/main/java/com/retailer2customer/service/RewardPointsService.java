package com.retailer2customer.service;
import com.retailer2customer.model.CustomerRewardPoints;
import com.retailer2customer.model.UserRequest;

public interface RewardPointsService {
	
	  long calculate (long amountspent);
	  CustomerRewardPoints fetchCustomerById(UserRequest userrequest);
  
}
