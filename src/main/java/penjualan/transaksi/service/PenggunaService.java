package penjualan.transaksi.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import penjualan.transaksi.model.Pengguna;
import penjualan.transaksi.repository.PenggunaRepository;

/**
 *
 * @author MSI-JO
 */
@Service
@AllArgsConstructor
public class PenggunaService {

    private PenggunaRepository penggunaRepository;

    public List<Pengguna> getAll() {
        return penggunaRepository.findAll();
    }

    public Pengguna getById(Long id) {
        return penggunaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "User id not found"
                        ));
    }

//    public Pengguna create(Pengguna pengguna) {
//        pengguna.getKaryawan().setPengguna(pengguna);
//        return penggunaRepository.save(pengguna);
//    }
    

    public Pengguna update(Long id, Pengguna pengguna) {
        getById(id);
        pengguna.setId(id);
        return penggunaRepository.save(pengguna);
    }

    public Pengguna delete(Long id) {
        Pengguna pengguna = getById(id);
        penggunaRepository.delete(pengguna);
        return pengguna;
    }

    public Pengguna create(Pengguna pengguna) {
        pengguna.getKaryawan().equals(pengguna);
        return penggunaRepository.save(pengguna);
    }
}
