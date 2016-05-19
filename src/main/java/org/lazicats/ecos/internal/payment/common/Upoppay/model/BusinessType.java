package org.lazicats.ecos.internal.payment.common.Upoppay.model;

public enum BusinessType{
		NORMAL("01"),
		SPLIT("02"),
		REALNAME("03"),
		ABROAD("04"),
		CUSTOME_SPLIT("05");
		private String code;
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}

		BusinessType(String code){
			this.code = code;
		}
	}