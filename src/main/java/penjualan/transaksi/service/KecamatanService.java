package penjualan.transaksi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import penjualan.transaksi.model.Kecamatan;
import penjualan.transaksi.repository.KecamatanRepository;

@Service
public class KecamatanService {

    private KecamatanRepository kecamatanRepository;

    @Autowired
    public KecamatanService(KecamatanRepository kecamatanRepository) {
        this.kecamatanRepository = kecamatanRepository;
    }

    public List<Kecamatan> getAll() {
        return kecamatanRepository.findAll();
    }

    public Kecamatan getById(Long id) {
        return kecamatanRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kecamatan not found"));
    }

    public Kecamatan create(Kecamatan kecamatan) {
        if (kecamatan.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Kecamatan already exists");
        }
        if (kecamatanRepository.findByName(kecamatan.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Kecamatan name already exists");
        }
        return kecamatanRepository.save(kecamatan);
    }

    public Kecamatan update(Long id, Kecamatan kecamatan) {
        getById(id);
        kecamatan.setId(id);
        return kecamatanRepository.save(kecamatan);
    }

    public Kecamatan delete(Long id) {
        Kecamatan kecamatan = getById(id);
        kecamatanRepository.delete(kecamatan);
        return kecamatan;
    }

}
