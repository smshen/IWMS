/**
 * GatewayOrderQuery.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.lazicats.ecos.internal.payment.common.Rmbport.services.gatewayOrderQuery;

import org.lazicats.ecos.internal.payment.common.Rmbport.dto.gatewayquery.GatewayOrderQueryRequest;
import org.lazicats.ecos.internal.payment.common.Rmbport.dto.gatewayquery.GatewayOrderQueryResponse;

public interface GatewayOrderQuery extends java.rmi.Remote {
    public GatewayOrderQueryResponse gatewayOrderQuery(GatewayOrderQueryRequest request) throws java.rmi.RemoteException;
}
