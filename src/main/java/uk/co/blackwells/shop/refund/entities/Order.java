package uk.co.blackwells.shop.refund.entities;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author mikelimassol
 *
 */
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final Integer PRIME_NUMBER = 31;
	
	private Long id;
	
	private Boolean completed;
	
	private Double total;
	
	private Shipping shipping;
	
	private List<OrderItem> items;
	
	private List<Transaction> transactions;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return the completed
	 */
	public Boolean getCompleted() {
		return completed;
	}

	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(final Boolean completed) {
		this.completed = completed;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(final Double total) {
		this.total = total;
	}

	/**
	 * @return the shipping
	 */
	public Shipping getShipping() {
		return shipping;
	}

	/**
	 * @param shipping the shipping to set
	 */
	public void setShipping(final Shipping shipping) {
		this.shipping = shipping;
	}

	/**
	 * @return the items
	 */
	public List<OrderItem> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(final List<OrderItem> items) {
		this.items = items;
	}

	/**
	 * @return the transactions
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(final List<Transaction> transactions) {
		this.transactions = transactions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = PRIME_NUMBER;
		int result = 1;
		result = prime * result + ((completed == null) ? 0 : completed.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((shipping == null) ? 0 : shipping.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
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
		Order other = (Order) obj;
		if (completed == null) {
			if (other.completed != null) {
				return false;
			}
		} else if (!completed.equals(other.completed)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (items == null) {
			if (other.items != null) {
				return false;
			}
		} else if (!items.equals(other.items)) {
			return false;
		}
		if (shipping == null) {
			if (other.shipping != null) {
				return false;
			}
		} else if (!shipping.equals(other.shipping)) {
			return false;
		}
		if (total == null) {
			if (other.total != null) {
				return false;
			}
		} else if (!total.equals(other.total)) {
			return false;
		}
		if (transactions == null) {
			if (other.transactions != null) {
				return false;
			}
		} else if (!transactions.equals(other.transactions)) {
			return false;
		}
		return true;
	}
	
	

}
