package uk.co.blackwells.shop.refund.entities;

import java.io.Serializable;

public class ItemShippingCharge implements Serializable {
	
	private static final long serialVersionUID = 2592464180119156667L;

	private static final Integer PRIME_NUMBER = 31;
	
	private Long id;
	
	private Item item;
	
	private Shipping shipping;
	
	private Double charge;

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
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(final Item item) {
		this.item = item;
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
	 * @return the charge
	 */
	public Double getCharge() {
		return charge;
	}

	/**
	 * @param charge the charge to set
	 */
	public void setCharge(final Double charge) {
		this.charge = charge;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = PRIME_NUMBER;
		int result = 1;
		result = prime * result + ((charge == null) ? 0 : charge.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((shipping == null) ? 0 : shipping.hashCode());
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
		ItemShippingCharge other = (ItemShippingCharge) obj;
		if (charge == null) {
			if (other.charge != null) {
				return false;
			}
		} else if (!charge.equals(other.charge)) {
			return false;
		}
		if (item == null) {
			if (other.item != null) {
				return false;
			}
		} else if (!item.equals(other.item)) {
			return false;
		}
		if (shipping == null) {
			if (other.shipping != null) {
				return false;
			}
		} else if (!shipping.equals(other.shipping)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemShippingCharge [item=" + item + ", shipping=" + shipping + ", charge=" + charge + "]";
	}
	
	
	
	
	 

}
