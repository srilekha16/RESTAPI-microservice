package com.retailer2customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.retailer2customer.entity.Transaction;
import com.retailer2customer.model.CustomerRewardPoints;
import com.retailer2customer.model.UserRequest;
import com.retailer2customer.repository.TransactionRepository;
import com.retailer2customer.service.RewardPointsService;

@Service
public class RewardPointsServiceImpl implements RewardPointsService{
	
	private static final Logger logger = LogManager.getLogger(RewardPointsServiceImpl.class);

	@Autowired
	private TransactionRepository transactionrepository;
	private static int slabrate1=50;
	private static int slabrate2=100;
	
	
	
	/**
	 * Fetch the customer details and return CustomerRewardPoints * 
	 * 
	 * @param UserRequest
	 *       <pre>
	 *            userid --- id to indicate the customer
	 *        </pre>
	 * 
	 * @return Customer Reward Points
	 *  
	 */
	public CustomerRewardPoints fetchCustomerById(UserRequest userrequest) {
		
		var customerdetails=new CustomerRewardPoints();
		
		try {
			Transaction response= transactionrepository.findById(Long.valueOf(userrequest.getUserid())).orElseThrow(Exception::new);
			
			long rewardpointsofmonth1=calculate(response.getFirstMonthAmount());
			long rewardpointsofmonth2=calculate(response.getSecondMonthAmount());
			long rewardpointsofmonth3=calculate(response.getThirdMonthAmount());
			long totalrewardpoints=calculate(response.getTotalPoints());

			customerdetails= new CustomerRewardPoints();
			customerdetails.setNameOfCustomer(response.getNameOfCustomer());
			customerdetails.setRewardsForMonth1(rewardpointsofmonth1);
			customerdetails.setRewardsForMonth2(rewardpointsofmonth2);
			customerdetails.setRewardsForMonth3(rewardpointsofmonth3);
			customerdetails.setTotalRewards(totalrewardpoints);
			
						
         	} catch (Exception e) {
         		
			logger.error("Exception while getting customer reward points for 3 months and total", e.getMessage());
		}
		
		return customerdetails;

	}


	 /**  calculate reward points **/
	
	public long calculate (long points) {
		long rewards=0L;

		if(points>50 && points>100) {
			rewards=(slabrate2-slabrate1)+((points-slabrate2)*2);
		}
		else if(points>50) {
			rewards=(points-slabrate1);
		}
		return rewards;

	}

}