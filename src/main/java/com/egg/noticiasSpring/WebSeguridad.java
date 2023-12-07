package com.egg.noticiasSpring;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface WebSeguridad {
    void configure(HttpSecurity http) throws Exception;
}
