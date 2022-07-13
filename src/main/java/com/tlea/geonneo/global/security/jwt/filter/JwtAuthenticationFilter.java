package com.tlea.geonneo.global.security.jwt.filter;

import com.tlea.geonneo.global.security.auth.AuthDetailsService;
import com.tlea.geonneo.global.security.jwt.JwtTokenProvider;
import com.tlea.geonneo.global.security.jwt.JwtValidateService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthDetailsService authDetailsService;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtValidateService jwtValidateService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = jwtTokenProvider.resolveToken(request);
        if (accessToken != null) setAuthentication(accessToken, request);
        filterChain.doFilter(request, response);
    }

    private void setAuthentication(String token, HttpServletRequest request) throws ExpiredJwtException {
        UserDetails userDetails = authDetailsService.loadUserByUsername(jwtValidateService.getDongho(token));
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public JwtAuthenticationFilter(
            AuthDetailsService authDetailsService,
            JwtTokenProvider jwtTokenProvider,
            JwtValidateService jwtValidateService
    ) {
        this.authDetailsService = authDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.jwtValidateService = jwtValidateService;
    }
}
