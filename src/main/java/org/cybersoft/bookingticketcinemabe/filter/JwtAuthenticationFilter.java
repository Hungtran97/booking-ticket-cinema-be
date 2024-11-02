package org.cybersoft.bookingticketcinemabe.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.cybersoft.bookingticketcinemabe.utils.JwtHelper;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtHelper jwtHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (jwtHelper.validateToken(token)) {
                String emailAndRoles = jwtHelper.introspectToken(token);
                String[] parts = emailAndRoles.split(":");
                String email = parts[0];
                String roles = parts.length > 1 ? parts[1] : "";
                List<GrantedAuthority> authorities = Arrays.stream(roles.split(","))
                        .map(role -> new SimpleGrantedAuthority(role.trim()))
                        .collect(Collectors.toList());
                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    Authentication authenticationToken = new UsernamePasswordAuthenticationToken(email, null, authorities);
                    SecurityContext context = SecurityContextHolder.getContext();
                    context.setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
