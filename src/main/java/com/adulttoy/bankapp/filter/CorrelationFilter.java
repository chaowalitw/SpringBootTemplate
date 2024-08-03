package com.adulttoy.bankapp.filter;


import com.adulttoy.bankapp.configuration.Constants;
import com.adulttoy.bankapp.util.WebUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorrelationFilter implements Filter {

    private static final String X_CORRELATION_ID = "X-CORRELATION-ID";
    private static final String CORRELATION_ID = "CORRELATION_ID";

    @Autowired
    ObjectMapper jsonObjectMapper;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Initiating CorrelationFilter filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String xCorrelationId = request.getHeader(X_CORRELATION_ID);
        xCorrelationId = StringUtils.isEmpty(xCorrelationId)
                ? request.getHeader(Constants.REQUEST_UID)
                : xCorrelationId;
        xCorrelationId = StringUtils.isEmpty(xCorrelationId)
                ? UUID.randomUUID().toString()
                : xCorrelationId;

        String requestAppId = request.getHeader(Constants.REQUEST_APP_ID);
        ThreadContext.put(CORRELATION_ID, xCorrelationId);
        ThreadContext.put(Constants.REQUEST_UID, xCorrelationId);
        ThreadContext.put(Constants.REQUEST_APP_ID, request.getHeader(Constants.REQUEST_APP_ID));
        ThreadContext.put(Constants.REQUEST_DATETIME, request.getHeader(Constants.REQUEST_DATETIME));
        ThreadContext.put(Constants.REQUEST_SERVICE_NAME, request.getHeader(Constants.REQUEST_SERVICE_NAME));
        //ThreadContext.put(Constants.REQUEST_ACRONYM, (request.getHeader(Constants.REQUEST_ACRONYM) != null ? request.getHeader(Constants.REQUEST_ACRONYM) : null));
        // ThreadContext.put(Constants.AUTHORIZATION, (request.getHeader(Constants.AUTHORIZATION) != null ? request.getHeader(Constants.AUTHORIZATION) : null));

        Instant start = Instant.now();
        try {
            filterChain.doFilter(request, response);
        } finally {
            if (!WebUtils.isActuatorEndpoints(request)) {
                Instant finish = Instant.now();
                long time = Duration.between(start, finish).toMillis();
                /*log.trace("[Performance] | {} ", jsonObjectMapper.writeValueAsString(PerformanceLog.builder()
                        .appid(requestAppId)
                        .service_name(request.getHeader(Constants.REQUEST_SERVICE_NAME))
                        .status(response.getStatus())
                        .duration(time)
                        .build()));*/
            }
        }
    }
}
