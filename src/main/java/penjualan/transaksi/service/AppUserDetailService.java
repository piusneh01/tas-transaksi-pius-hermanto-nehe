package penjualan.transaksi.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import penjualan.transaksi.model.AppUserDetail;
import penjualan.transaksi.model.Pengguna;
import penjualan.transaksi.repository.PenggunaRepository;

@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService{
    
    private PenggunaRepository penggunaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Pengguna pengguna = penggunaRepository.findByUsername(username).
                orElseThrow(()-> new UsernameNotFoundException("Username or password is not correct"));
        return new AppUserDetail(pengguna);
    }
    
}
