package com.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.api.requestType.FnacActionType;
import com.api.xmlEntity.BaseRequest;
import com.api.xmlEntity.auth.AuthRequest;
import com.api.xmlEntity.auth.AuthResponse;
import com.utils.JaxbUtil;
import lombok.Data;
import org.apache.commons.lang.StringUtils;


@Data
public class FnacCallBean {

	private AuthRequest authRequest;
	private AuthResponse authResponse;
	private String requestUrl;//api请求地址

	private boolean validityFlag;//用于验证token过期
	
	/**
	 * 设置请求地址和请求令牌参数
	 */
	public FnacCallBean(ApiConfig apiConfig) throws Exception {
		this.requestUrl = apiConfig.getServiceUrl() + "/";// api请求地址
		this.authRequest = new AuthRequest(apiConfig.getPartnerId(), apiConfig.getShopId(),	apiConfig.getApiKey());// 请求令牌参数
		queryAuthToken();
	}
	
	/**
	 * 请求api, 设置AuthResponse
	 */
	private void queryAuthToken() throws Exception {
		String xml = JaxbUtil.toXML(authRequest);
		System.err.println("auth xml format: ");
		System.err.println(xml);
		String result = post(requestUrl + FnacActionType.AUTH, xml);
		if (StringUtils.isNotBlank(result)) {
			setAuthResponse(JaxbUtil.fromXML(result, AuthResponse.class));
		} else {
			throw new Exception("request auth return null");
		}
	}
	
	/**
	 * 执行请求api
	 * @param request 请求api的xml参数类
	 * @param fnacActionType 请求类型--接口FnacActionType
	 * @return
	 */
	public String callBack(BaseRequest request, String fnacActionType) {
		try {
			if (StringUtils.isBlank(request.getPartnerId()) || StringUtils.isBlank(request.getShopId()) || StringUtils.isBlank(request.getToken())) {
				queryAuthToken();
				//设置请求令牌
				request.setPartnerId(this.authRequest.getPartnerId());
				request.setShopId(this.authRequest.getShopId());
				request.setToken(this.authResponse.getToken());
			}
			//执行具体api请求
			String baseRequestXml = JaxbUtil.toXML(request);
			String result = post(this.requestUrl + fnacActionType, baseRequestXml);//请求
			setValidityFlag(false);
			return result;
		} catch (Exception e) {
			System.err.println("request error");
			if (!validityFlag) { //假定异常原因为token过期, 重新获取token再请求
				request.setToken(null);
				setValidityFlag(true);
				return callBack(request, fnacActionType);
			}
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过传入请求地址和xml参数, 获取返回结果
	 * @param request Url请求地址
	 * @param xmlInfo xml请求参数
	 * @return
	 * @throws Exception 
	 */
	private String post(String requestUrl, String xmlInfo) throws Exception {
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		URL url = new URL(requestUrl);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "text/xml");
		conn.setDoOutput(true);
		OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
		System.out.println("urlStr=" + requestUrl);
		// 传递xml请求参数
		out.write(new String(xmlInfo.getBytes("UTF-8")));
		out.flush();
		out.close();

		InputStream inputStream = conn.getInputStream();
		rd = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		while ((line = rd.readLine()) != null) {
			result += line;
		}
		rd.close();
		return result;
	}

}
