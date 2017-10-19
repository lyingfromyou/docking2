package com.lying;

import com.api.ApiConfig;
import com.api.FnacCallBean;
import com.api.requestType.FnacActionType;
import com.api.xmlEntity.order.OrdersQueryRequest;
import com.api.xmlEntity.order.OrdersQueryResponse;
import com.api.xmlEntity.order.States;
import com.constentEnum.OrderState;
import com.utils.Dumper;
import com.utils.JaxbUtil;

import java.util.Arrays;

public class QueryOrdersDemo {

    public static void main(String[] args) throws Exception {
        String partnerId = "9A3A5218-031B-1447-0900-95EBB2E57A4E";
        String shopId = "7FA14FD4-61B5-0E97-5F4F-3BE03403DF5B";
        String key = "58FAE52A-AB34-3223-4194-C53E30065679";
        ApiConfig apiConfig = new ApiConfig();
        apiConfig.setPartnerId(partnerId);
        apiConfig.setShopId(shopId);
        apiConfig.setApiKey(key);
        apiConfig.setServiceUrl("https://vendeur.fnac.com/api.php");
        FnacCallBean callBean = new FnacCallBean(apiConfig);

        OrdersQueryRequest request = new OrdersQueryRequest();

        request.setPartnerId(partnerId);
        request.setShopId(shopId);
//		request.setToken("59CC83DC-55B1-FCBD-A82D-63746256AB13");

        request.setStates(new States(Arrays.asList(OrderState.ToShip.getState())));

        System.err.println(JaxbUtil.toXML(request));
        String result = callBean.callBack(request, FnacActionType.ORDERS_QUERY);
        OrdersQueryResponse response = JaxbUtil.fromXML(result, OrdersQueryResponse.class);
        Dumper.dump(response);

//		String token = "";
//		String s = "<?xml version=\"1.0\" encoding=\"utf-8\"?> " +
//		"<carriers_query xmlns=\"http://www.fnac.com/schemas/mp-dialog.xsd\"  "+
//				"shop_id=\"" + shopId + "\" partner_id=\"" + partnerId + "\" token=\"" + token + "\"> " +
//		 "<query>all</query> " +
//		 "</carriers_query>";
//
//
//

//		OrderUpdate orderUpdate = new OrderUpdate(new OrderDetailUpdate(OrderDetailStateUpdate.SHIPPED));


		/*
        String transactionId = "ccc";

		OrderDetailUpdate orderDetailUpdate = new OrderDetailUpdate(OrderDetailStateUpdate.ACCEPTED);
		OrderUpdate orderUpdate = new OrderUpdate(transactionId, OrderUpdateAction.ACCEPT_ALL_ORDERS, orderDetailUpdate);
		OrdersUpdateRequest updateRequest = new OrdersUpdateRequest(partnerId, shopId, token, orderUpdate);
		System.err.println("xml format: ");
		System.err.println(JaxbUtil.toXML(updateRequest));
		*/

//		OrdersUpdateRequest request = new OrdersUpdateRequest();
//		request.setOrder(orderUpdate);
//		System.err.println(JaxbUtil.toXML(request));
    }
}
