package com.github.jinahya.juso.go.kr.web.bind.addrlink.type;

import com.github.jinahya.juso.go.kr.web.bind.type._BaseResponseTypeTest;

abstract class _AddrlinkResponseTypeTest<TYPE extends _AddrlinkResponseType<?>>
        extends _BaseResponseTypeTest<TYPE> {

    _AddrlinkResponseTypeTest(final Class<TYPE> typeClass) {
        super(typeClass);
    }
}