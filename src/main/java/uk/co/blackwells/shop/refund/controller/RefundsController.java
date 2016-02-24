package uk.co.blackwells.shop.refund.controller;

import uk.co.blackwells.shop.refund.service.RefundService;

/**
 * 
 * @author mikelimassol
 *
 */
public class RefundsController {
	
	private RefundService refundService;
	
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
	public Boolean Refund(Long refId, Double amount, String reason) {
		
		return refundService.refund(refId, amount, reason);
		
	}

}
