package com.example.clinifyauthorization.service.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.time.Duration;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Retrieve the JSESSIONID cookie from the response headers
        String cookieHeader = response.getHeader(HttpHeaders.SET_COOKIE);
        String cookieValue = null;
        if (cookieHeader != null) {
            String[] cookies = cookieHeader.split("; ");
            for (String cookie : cookies) {
                if (cookie.startsWith("JSESSIONID")) {
                    String[] parts = cookie.split("=");
                    if (parts.length == 2) {
                        String cookieName = parts[0];
                        cookieValue = parts[1];
                        // Use the cookieName and cookieValue as needed
                        break;
                    }
                }
            }
        }

        // Modify the cookie settings
        ResponseCookie cookie = ResponseCookie.from("JSESSIONID", cookieValue) // key & value
//                .httpOnly(true)
                .secure(true)
                //    .domain("localhost")  // host
                //    .path("/")      // path
//                .maxAge(Duration.ofHours(1))
                .sameSite("none")  // sameSite
                .build();

        // Response to the client
        response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());

        Cookie cookie1 = new Cookie("JSESSIONID", cookieValue);
        cookie1.setAttribute("SameSite","none");
        response.addCookie(cookie1);

        // Redirect to the default success URL
        redirectStrategy.sendRedirect(request, response, "/user/data");
    }
}
