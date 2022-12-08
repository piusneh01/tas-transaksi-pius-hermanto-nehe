
package penjualan.transaksi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import penjualan.transaksi.model.Kecamatan;
import penjualan.transaksi.service.KecamatanService;

/**
 *
 * @author MSI-JO
 */
@RestController
@RequestMapping("/kecamatan")
public class KecamatanController {

    private KecamatanService kecamatanService;

    @Autowired
    public KecamatanController(KecamatanService kecamatanService) {
        this.kecamatanService = kecamatanService;
    }

    // http://localhost:8085/kecamatan
    @GetMapping
    public List<Kecamatan> getAll() {
        return kecamatanService.getAll();
    }

    @GetMapping("/{id}")
    public Kecamatan getById(@PathVariable Long id) {
        return kecamatanService.getById(id);
    }
    // http://localhost:8085/kecamatan/1   (PathVariable) Detail

    @PostMapping
    public Kecamatan create(@RequestBody Kecamatan kecamatan) {
        return kecamatanService.create(kecamatan);
    }
    // http://localhost:8085/kecamatan

    @PutMapping("/{id}")
    public Kecamatan update(@PathVariable Long id, @RequestBody Kecamatan kecamatan) {
        return kecamatanService.update(id, kecamatan);
    }
    // http://localhost:8085/kecamatan/1

    @DeleteMapping("/{id}")
    public Kecamatan delete(@PathVariable Long id) {
        return kecamatanService.delete(id);
    }
    // http://localhost:8085/kecamatan/1

}
