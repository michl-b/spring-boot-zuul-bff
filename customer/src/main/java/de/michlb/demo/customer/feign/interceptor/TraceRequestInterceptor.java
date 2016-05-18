package de.michlb.demo.customer.feign.interceptor;

import com.shedhack.trace.request.api.constant.HttpHeaderKeysEnum;
import com.shedhack.trace.request.api.threadlocal.RequestThreadLocalHelper;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *     Before any requests are made Feign Clients we set some header properties.
 *     These properties have been set by the Trace Request Filter.
 * </pre>
 */
@Component
public class TraceRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {

        if( RequestThreadLocalHelper.get() !=null) {

            requestTemplate.header(HttpHeaderKeysEnum.CALLER_ID.key(), RequestThreadLocalHelper.get().getRequestId());
            requestTemplate.header(HttpHeaderKeysEnum.GROUP_ID.key(), RequestThreadLocalHelper.get().getGroupId());
        }
    }
}
