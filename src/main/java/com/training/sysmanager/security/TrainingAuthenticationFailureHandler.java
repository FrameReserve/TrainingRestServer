package com.training.sysmanager.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Athos on 2016-07-18.
 */
public class TrainingAuthenticationFailureHandler extends ExceptionMappingAuthenticationFailureHandler {

    private final Map<String, String> failureUrlMap = new HashMap<String, String>();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        System.out.println(exception.getClass().getName());
        String url = failureUrlMap.get(exception.getClass().getName());

        if (url != null) {
            getRedirectStrategy().sendRedirect(request, response, url);
        }
        else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }

    /**
     * Sets the map of exception types (by name) to URLs.
     *
     * @param failureUrlMap the map keyed by the fully-qualified name of the exception
     * class, with the corresponding failure URL as the value.
     *
     * @throws IllegalArgumentException if the entries are not Strings or the URL is not
     * valid.
     */
    public void setExceptionMappings(Map<?, ?> failureUrlMap) {
        this.failureUrlMap.clear();
        for (Map.Entry<?, ?> entry : failureUrlMap.entrySet()) {
            Object exception = entry.getKey();
            Object url = entry.getValue();
            Assert.isInstanceOf(String.class, exception,
                    "Exception key must be a String (the exception classname).");
            Assert.isInstanceOf(String.class, url, "URL must be a String");
            Assert.isTrue(UrlUtils.isValidRedirectUrl((String) url),
                    "Not a valid redirect URL: " + url);
            this.failureUrlMap.put((String) exception, (String) url);
        }
    }
}
