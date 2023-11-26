package com.github.jinahya.juso.go.kr.api.proxy.context.properties;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import reactor.netty.http.client.HttpClient;

@ConfigurationProperties(prefix = "juso-go-kr.addrlink.addr-link-api")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
public class AddrLinkApiConfigurationProperties
        extends _AddrApiConfigurationProperties {

    public static final String REQUEST_URI = "/addrlink/addrLinkApi.do";

    public static final String BASE_URL = "https://business.juso.go.kr" + REQUEST_URI;

    // -----------------------------------------------------------------------------------------------------------------
    @PostConstruct
    private void onPostConstruct() {
        log.debug("");
    }

    @Override
    public HttpClient newHttpClient() {
        return super.newHttpClient()
                .baseUrl(getBaseUrl());
    }

    // -----------------------------------------------------------------------------------------------------------------
    private String baseUrl = BASE_URL;
}
