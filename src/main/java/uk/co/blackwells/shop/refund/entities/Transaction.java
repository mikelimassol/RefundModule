package uk.co.blackwells.shop.refund.entities;

import java.io.Serializable;
import java.util.List;

public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final Integer PRIME_NUMBER = 31;
	
	private Long refId;
	
	private Order order;
	
	private Double amountPaid;
	
	private List<Refund> refunds;

	/**
	 * @return the refId
	 */
	public Long getRefId() {
		return refId;
	}

	/**
	 * @param refId the refId to set
	 */
	public void setRefId(final Long refId) {
		this.refId = refId;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(final Order order) {
		this.order = order;
	}

	/**
	 * @return the amountPaid
	 */
	public Double getAmountPaid() {
		return amountPaid;
	}

	/**
	 * @param amountPaid the amountPaid to set
	 */
	public void setAmountPaid(final Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	/**
	 * @return the refunds
	 */
	public List<Refund> getRefunds() {
		return refunds;
	}

	/**
	 * @param refunds the refunds to set
	 */
	public void setRefunds(final List<Refund> refunds) {
		this.refunds = refunds;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = PRIME_NUMBER;
		int result = 1;
		result = prime * result + ((amountPaid == null) ? 0 : amountPaid.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((refId == null) ? 0 : refId.hashCode());
		result = prime * result + ((refunds == null) ? 0 : refunds.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Transaction other = (Transaction) obj;
		if (amountPaid == null) {
			if (other.amountPaid != null) {
				return false;
			}
		} else if (!amountPaid.equals(other.amountPaid)) {
			return false;
		}
		if (order == null) {
			if (other.order != null) {
				return false;
			}
		} else if (!order.equals(other.order)) {
			return false;
		}
		if (refId == null) {
			if (other.refId != null) {
				return false;
			}
		} else if (!refId.equals(other.refId)) {
			return false;
		}
		if (refunds == null) {
			if (other.refunds != null) {
				return false;
			}
		} else if (!refunds.equals(other.refunds)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [refId=" + refId + ", order=" + order + ", amountPaid=" + amountPaid + ", refunds="
				+ refunds + "]";
	}
	
}
