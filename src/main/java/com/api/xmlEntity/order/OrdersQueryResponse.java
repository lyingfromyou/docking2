package com.api.xmlEntity.order;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "orders_query_response")
public class OrdersQueryResponse {

	@XmlElement
	private Integer page;// 页码

	@XmlElement(name = "total_paging")
	private Integer totalPaging;// 可用页数

	@XmlElement(name = "nb_total_per_page")
	private Integer totalPerPage;// 每页结果数

	@XmlElement(name = "nb_total_result")
	private Integer totalResult;// 结果数量

	@XmlElement(name = "order")
	private List<Order> orders;

	@XmlElement(name = "error")
	private Error error;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotalPaging() {
		return totalPaging;
	}

	public void setTotalPaging(Integer totalPaging) {
		this.totalPaging = totalPaging;
	}

	public Integer getTotalPerPage() {
		return totalPerPage;
	}

	public void setTotalPerPage(Integer totalPerPage) {
		this.totalPerPage = totalPerPage;
	}

	public Integer getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(Integer totalResult) {
		this.totalResult = totalResult;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
