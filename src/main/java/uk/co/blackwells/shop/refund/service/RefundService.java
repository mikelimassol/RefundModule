package uk.co.blackwells.shop.refund.service;

/**
 * 
 * @author mikelimassol
 *
 */
public interface RefundService {
		/**
		  * refunds the amount
		 * @param refId
		 * 			   the transaction reference id used to refund
		 * @param Amount
		 * 			    the amount to be refunded
		 * @param reason
		 * 				the reason to be refunded
		 * @return
		 */
		Boolean refund(Long refId, Double amount, String reason);
}