package com.github.jinahya.juso.go.kr.streotype;

import com.github.jinahya.juso.go.kr.context.AddrEngApiConfiguration;
import com.github.jinahya.juso.go.kr.web.bind._type._BaseTypeGroup;
import com.github.jinahya.juso.go.kr.web.bind.addrlink._type.AddrEngApiRequest;
import com.github.jinahya.juso.go.kr.web.bind.addrlink._type.AddrEngApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Validated
@Service
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
public class AddrEngService
        extends _BaseService {

    public static final String CACHE_NAME_ADDR_ENG = "addrEng";

    // -----------------------------------------------------------------------------------------------------------------
//    @Cacheable(cacheNames = {CACHE_NAME_ADDR_ENG})
    @Validated({_BaseTypeGroup.class})
    public Mono<AddrEngApiResponse> get(@Valid @NotNull final AddrEngApiRequest request) {
        return webClient
                .get()
                .uri(b -> request.put(b).build())
                .retrieve()
                .bodyToMono(AddrEngApiResponse.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @AddrEngApiConfiguration.AddrEngApi
    @Autowired
    @SuppressWarnings({"java:S6813"})
    private WebClient webClient;

    @Autowired
    @SuppressWarnings({"java:S6813"})
    private Validator validator;
}
