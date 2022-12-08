package penjualan.transaksi.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import penjualan.transaksi.model.Peran;
import penjualan.transaksi.repository.PeranRepository;

@Service
@AllArgsConstructor
public class PeranService {

    private PeranRepository peranRepository;

    public List<Peran> getAll() {
        return peranRepository.findAll();
    }

    public Peran getById(Long id) {
        return peranRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Peran id not found"
                        ));
    }

    public Peran create(Peran peran) {
        return peranRepository.save(peran);
    }

    public Peran update(Long id, Peran peran) {
        getById(id);
        peran.setId(id);
        return peranRepository.save(peran);
    }

    public Peran delete(Long id) {
        Peran peran = getById(id);
        peranRepository.delete(peran);
        return peran;
    }

}
