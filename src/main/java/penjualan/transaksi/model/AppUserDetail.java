package penjualan.transaksi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AppUserDetail implements UserDetails {

    private Pengguna pengguna;

    public AppUserDetail(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        List<GrantedAuthority> authroities = new ArrayList<>();
        pengguna.getPerans().forEach(peran -> {
            String peranName = "PERAN_"+ peran.getName().toUpperCase();
            authroities.add(new SimpleGrantedAuthority(peranName));
            
            peran.getPrivilages().forEach(privilage -> {
                String privilageName = privilage.getName().toUpperCase();
                authroities.add(new SimpleGrantedAuthority(privilageName));
            });
        });
        
        return authroities;
    }

    @Override
    public String getPassword() {
        return pengguna.getPassword();
    }

    @Override
    public String getUsername() {
        return pengguna.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !pengguna.getIsAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return pengguna.getIsEnabled();
    }

}
