package org.lazicats.ecos.internal.payment.common.Upoppay.model;


public class SplitParam extends Param{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4154754247738844889L;

	public void addSplit(String merId,String splitAmount) {
		put(merId, splitAmount);
	}
}
