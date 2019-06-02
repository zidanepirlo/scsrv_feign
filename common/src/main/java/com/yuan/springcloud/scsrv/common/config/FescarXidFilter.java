package com.yuan.springcloud.scsrv.common.config;

import com.alibaba.fescar.core.context.RootContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * FescarXidFilter
 *
 * @author yuanqing
 * @create 2019-04-02 14:06
 **/
public class FescarXidFilter extends OncePerRequestFilter {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String xid = RootContext.getXID();
        String restXid = request.getHeader("Fescar-Xid");
        boolean bind = false;
        if(StringUtils.isBlank(xid)&& StringUtils.isNotBlank(restXid)){
            RootContext.bind(restXid);
            bind = true;
            logger.info("bind[" + restXid + "] to RootContext");
        }
        try{
            filterChain.doFilter(request, response);
        } finally {
            if (bind) {
                String unbindXid = RootContext.unbind();
                logger.info("unbind[" + unbindXid + "] from RootContext");
                if (!restXid.equalsIgnoreCase(unbindXid)) {
                    logger.info("xid in change during http rest from " + restXid + " to " + unbindXid);
                    if (unbindXid != null) {
                        RootContext.bind(unbindXid);
                        logger.info("bind [" + unbindXid + "] back to RootContext");
                    }
                }
            }
        }
    }
}