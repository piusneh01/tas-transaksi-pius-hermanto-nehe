package penjualan.transaksi.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import penjualan.transaksi.service.AppUserDetailService;

/**
 *
 * @author MSI-JO
 */
@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private AppUserDetailService appUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(appUserDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/karyawan/**").permitAll()
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN", "MANAGER")
                .antMatchers("/kecamatan/**").permitAll()
                .antMatchers("/email/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

    }

}
