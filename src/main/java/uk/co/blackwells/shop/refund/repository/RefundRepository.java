package uk.co.blackwells.shop.refund.repository;

import uk.co.blackwells.shop.refund.entities.Refund;

/**
 * 
 * @author mikelimassol
 *
 */
public interface RefundRepository {

	/**
	 * retrieves the total of all the refunds related to a transaction
	 * 
	 * @param refId
	 *            transaction reference id
	 * @return the total of all the refunds of a specific transaction
	 */
	Double getRefundsTotalByRefId(Long refId);

	/**
	 * inserts a new refund to the database
	 * 
	 * @param refund
	 *            the refund to be saved
	 * @return status of insertion
	 */
	Boolean insert(Refund refund);

}
