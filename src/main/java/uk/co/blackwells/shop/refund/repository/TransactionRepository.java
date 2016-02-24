package uk.co.blackwells.shop.refund.repository;

import uk.co.blackwells.shop.refund.entities.Transaction;

public interface TransactionRepository {
	
	/**
	 * gets the transaction by id
	 * @param id
	 * 			the id to pass to get the transaction
	 * @return
	 * 		   transaction
	 */
	Transaction getByRefId(Long refId);
	

}
