package com.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 一般存储在数据库
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiConfig {

    private String apiKey;
    private String serviceUrl;
    private String partnerId;
    private String shopId;
}
