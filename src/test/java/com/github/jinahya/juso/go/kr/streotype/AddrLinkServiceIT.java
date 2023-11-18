package com.github.jinahya.juso.go.kr.streotype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jinahya.juso.go.kr.context.AddrLinkApiConfiguration;
import com.github.jinahya.juso.go.kr.context.CacheConfiguration;
import com.github.jinahya.juso.go.kr.context.properties.AddrLinkApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiResponse;
import com.github.jinahya.juso.go.kr.web.bind.type._BaseResultsType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        classes = {
                AddrLinkService.class,
                AddrLinkCacheMem.class,
                CacheConfiguration.class,
                AddrLinkApiConfiguration.class,
                AddrLinkApiConfigurationProperties.class,
                JacksonAutoConfiguration.class
        }
)
@Slf4j
class AddrLinkServiceIT {

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void __() throws JsonProcessingException {
        final var request = new AddrLinkApiRequest();
        request.setConfmKey(properties.getConfmKey());
        request.setKeyword("한국지역정보개발원");
        request.setResultType("json");
        for (var currentPage = 1; ; currentPage++) {
            request.setCurrentPage(currentPage);
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(request));
            // ---------------------------------------------------------------------------------------------------- when
            final AddrLinkApiResponse response = service.get(request).block();
            log.debug("response: {}", response);
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response));
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(response).isNotNull();
            final var results = response.getResults();
            assertThat(results).isNotNull();
            final var common = results.getCommon();
            assertThat(common).isNotNull().satisfies(c -> {
                assertThat(c.getErrorCode()).isEqualTo(_BaseResultsType.Common.PROPERTY_VALUE_ERROR_CODE_0);
            });
            final var juso = results.getJuso();
            assertThat(juso).isNotNull();
            if (juso.isEmpty()) {
                break;
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private AddrLinkApiConfigurationProperties properties;

    @Autowired
    private AddrLinkService service;

    @Autowired
    private ObjectMapper objectMapper;
}