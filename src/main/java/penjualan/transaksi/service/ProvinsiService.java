package penjualan.transaksi.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import penjualan.transaksi.model.Provinsi;
import penjualan.transaksi.repository.ProvinsiRepository;

@Service
@AllArgsConstructor
public class ProvinsiService {

    private ProvinsiRepository provinsiRepository;

    public List<Provinsi> getAll() {
        return provinsiRepository.findAll();
    }

    public Provinsi getById(Long id) {
        return provinsiRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Provinsi not found")
                );
    }

    public Provinsi create(Provinsi provinsi) {
        if (provinsi.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Provinsi already exists"
            );
        }
        if (provinsiRepository.existsByName(provinsi.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Provinsi name already exists");
        }
        return provinsiRepository.save(provinsi);
    }

    public Provinsi update(Long id, Provinsi provinsi) {
        getById(id);
        provinsi.setId(id);
        return provinsiRepository.save(provinsi);
    }

    public Provinsi delete(Long id) {
        Provinsi provinsi = getById(id);
        provinsiRepository.delete(provinsi);
        return provinsi;
    }
}
