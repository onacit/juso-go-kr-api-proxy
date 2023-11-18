package com.github.jinahya.juso.go.kr.context.properties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.client.HttpClient;

@ConfigurationProperties(prefix = "juso-go-kr.addrlink.addr-eng-api")
@Configuration
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class AddrEngApiConfigurationProperties
        extends _AddrApiConfigurationProperties {

    public static final String BASE_URL = "https://business.juso.go.kr/addrlink/addrEngApi.do";

    @Override
    public HttpClient newHttpClient() {
        return super.newHttpClient()
                .baseUrl(getBaseUrl());
    }

    // -----------------------------------------------------------------------------------------------------------------
    private String baseUrl = BASE_URL;
}