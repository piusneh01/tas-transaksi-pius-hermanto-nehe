package penjualan.transaksi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import penjualan.transaksi.model.Provinsi;
import penjualan.transaksi.service.ProvinsiService;

@RestController
@RequestMapping("/provinsi")
public class ProvinsiController {

    private ProvinsiService provinsiService;

    @Autowired
    public ProvinsiController(ProvinsiService provinsiService) {
        this.provinsiService = provinsiService;
    }
    
    @GetMapping
    public List<Provinsi> getAll() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities()                );
        return provinsiService.getAll();
    }

    @GetMapping("/{id}")
    public Provinsi getById(@PathVariable Long id) {
        return provinsiService.getById(id);
    }

    @PostMapping
    public Provinsi create(@RequestBody Provinsi provinsi) {
        return provinsiService.create(provinsi);
    }

    @PutMapping("/{id}")
    public Provinsi update(@PathVariable Long id, @RequestBody Provinsi provinsi) {
        return provinsiService.update(id, provinsi);
    }

    @DeleteMapping("/{id}")
    public Provinsi delete(@PathVariable Long id) {
        return provinsiService.delete(id);
    }
}
