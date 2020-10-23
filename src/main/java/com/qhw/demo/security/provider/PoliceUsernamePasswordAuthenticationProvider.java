package com.qhw.demo.security.provider;

import com.qhw.demo.security.token.PoliceUsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

public class PoliceUsernamePasswordAuthenticationProvider extends DaoAuthenticationProvider {

    @Override
    public boolean supports(Class<?> authentication) {
        return (PoliceUsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication));
    }
}
