package penjualan.transaksi.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import penjualan.transaksi.model.Karyawan;
import penjualan.transaksi.service.KaryawanService;

@RestController
@RequestMapping("/karyawan")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class KaryawanController {

    private KaryawanService karyawanService;

    @GetMapping
    public List<Karyawan> getAll() {
        return karyawanService.getAll();
    }

    @PreAuthorize("hasAuthority('READ_MANAGER')")
    @GetMapping("/{id}")
    public Karyawan getById(@PathVariable Long id) {
        return karyawanService.getById(id);
    }

    @PreAuthorize("hasAuthority('CREATE_USER')")
    @PostMapping
    public Karyawan create(@RequestBody Karyawan karyawan) {
        return karyawanService.create(karyawan);
    }

    @PutMapping("/{id}")
    public Karyawan update(@PathVariable Long id, @RequestBody Karyawan karyawan) {
        return karyawanService.update(id, karyawan);
    }

    @DeleteMapping("/{id}")
    public Karyawan delete(@PathVariable Long id) {
        return karyawanService.delete(id);
    }

}
