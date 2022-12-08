
package penjualan.transaksi.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import penjualan.transaksi.model.Karyawan;
import penjualan.transaksi.model.Peran;
import penjualan.transaksi.repository.KaryawanRepository;

@Service
@AllArgsConstructor
public class KaryawanService  {
    
    private KaryawanRepository karyawanRepository;
    private PeranService peranService;
    private PasswordEncoder passwordEncoder;
    
    public List<Karyawan> getAll(){
        return karyawanRepository.findAll();
    }
    
    public Karyawan getById(Long id){
        return karyawanRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Karyawan id not found"
                ));
    }
    
    public Karyawan create(Karyawan karyawan){
        // Set Peran
        List<Peran> perans = new ArrayList<>();
        perans.add(peranService.getById(1L));
        karyawan.getPengguna().setPeran(perans);
        
        // Set IsEnabled, IsAccountLocked
        karyawan.getPengguna().setIsAccountLocked(true);
        karyawan.getPengguna().setIsEnabled(Boolean.TRUE);
        
        // Set Password
        String password = karyawan.getPengguna().getPassword();
        karyawan.getPengguna().setPassword(passwordEncoder.encode(password));
        
        // Set Karyawan in User
        karyawan.getPengguna().setKaryawan(karyawan);
        
        return karyawanRepository.save(karyawan);
    }
    
    public Karyawan update(Long id, Karyawan karyawan){
        getById(id);
        karyawan.setId(id);
        return karyawanRepository.save(karyawan);
    }
    
    public Karyawan delete(Long id){
        Karyawan karyawan = getById(id);
        karyawanRepository.delete(karyawan);
        return karyawan;
    }
}
