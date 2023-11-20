package com.github.jinahya.juso.go.kr.web.bind.addrlink.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class AddrLinkApiResult
        extends _AddrlinkResultType<List<AddrLinkApiResultJuso>> {

    @Serial
    private static final long serialVersionUID = -3105641034884770051L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String PROPERTY_NAME_RESULTS = "results";

    public static final String PROPERTY_NAME_JUSO = "juso";

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    public List<AddrLinkApiResultJuso> getJuso() {
        return super.getData();
    }

    public void setJuso(final List<AddrLinkApiResultJuso> jusos) {
        super.setData(jusos);
    }
}
