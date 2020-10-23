package com.qhw.demo.config;


import com.qhw.demo.interceptor.JwtInterceptor;
import com.qhw.demo.security.JwtAuthenticationTokenFilter;
import com.qhw.demo.security.provider.PoliceUsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

//import com.qhw.demo.security.JwtAuthenticationTokenFilter;
import com.qhw.demo.security.JwtAuthenticationProvider;
import com.qhw.demo.security.JwtLoginFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    @Qualifier("policeDetailsServiceImpl")
    private UserDetailsService policeDetailsServiceImpl;

   // @Autowired
   // private JwtAuthenticationTokenFilter authenticationTokenFilter;

    //@Autowired
    //private JwtInterceptor jwtInterceptor;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
        http.cors().and().csrf().disable();
        // 退出登录处理器
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
        http.authorizeRequests()
                // 对于登录login 允许匿名访问
                .antMatchers("/login/test").anonymous()
                .antMatchers("/policelogin/test").anonymous()
                .antMatchers(
                        HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter,UsernamePasswordAuthenticationFilter.class);
//        // 开启登录认证流程过滤器
//       http.addFilterBefore(new JwtLoginFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
        // 访问控制时登录状态检查过滤器
        //http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);

    }

    /**
     * 解决 无法直接注入 AuthenticationManager
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }
    /**
     * 强散列哈希加密实现
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    /**
     * 身份认证接口
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.authenticationProvider(getPoliceUsernamePasswordAuthenticationProvider())     .userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    protected PoliceUsernamePasswordAuthenticationProvider getPoliceUsernamePasswordAuthenticationProvider(){
        PoliceUsernamePasswordAuthenticationProvider policeUsernamePasswordAuthenticationProvider=new PoliceUsernamePasswordAuthenticationProvider();
        policeUsernamePasswordAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        policeUsernamePasswordAuthenticationProvider.setUserDetailsService(policeDetailsServiceImpl);
        return policeUsernamePasswordAuthenticationProvider;
    }

}
