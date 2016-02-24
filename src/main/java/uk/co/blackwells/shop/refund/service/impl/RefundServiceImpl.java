package uk.co.blackwells.shop.refund.service.impl;

import uk.co.blackwells.shop.refund.entities.Refund;
import uk.co.blackwells.shop.refund.entities.Transaction;
import uk.co.blackwells.shop.refund.repository.RefundRepository;
import uk.co.blackwells.shop.refund.repository.TransactionRepository;
import uk.co.blackwells.shop.refund.service.RefundService;

public class RefundServiceImpl implements RefundService {
	
	private static final String INVALID_TRANSACTION_MESSAGE = "transaction does not exist";
	private static final String INVALID_AMOUNT_MESSAGE = "transaction does not exist";
	private static final String TRANSACTION_FULLY_REFUNDED_MESSAGE = "transaction has already been refunded";
	
	private RefundRepository refundRepository;
	
	private TransactionRepository transactionRepository;

	public Boolean refund(Long refId, Double amount, String reason) {
		
		Transaction transaction = null;
		double totalRefunds = 0;
		double amountEntitledToBeRefunded = 0;
		
		if(amount == null || amount == 0){
			throw new IllegalArgumentException(INVALID_AMOUNT_MESSAGE);
		}
		
	    transaction = transactionRepository.getByRefId(refId);
		
		if(transaction == null){
			throw new IllegalArgumentException(INVALID_TRANSACTION_MESSAGE);
		}
		
	    totalRefunds = refundRepository.getRefundsTotalByRefId(refId);
	    
	    if(totalRefunds >= transaction.getAmountPaid()){
	    	throw new IllegalArgumentException(TRANSACTION_FULLY_REFUNDED_MESSAGE);
	    }
	    
	    amountEntitledToBeRefunded = transaction.getAmountPaid() - totalRefunds;
	    
	    if(amount <= amountEntitledToBeRefunded){
	    	refundRepository.insert(new Refund(transaction,reason,amount));
	    	return true;
	    } else {
	    	return false;
	    }
		
	}
	
	
	

}
