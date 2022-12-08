/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.transaksi.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import penjualan.transaksi.model.Pengguna;
import penjualan.transaksi.service.PenggunaService;

/**
 *
 * @author MSI-JO
 */
@RestController
@RequestMapping("/pengguna")
@AllArgsConstructor
public class PenggunaController {

    private PenggunaService penggunaService;

    @GetMapping
    public List<Pengguna> getAll() {
        return penggunaService.getAll();
    }    

    @GetMapping("/{id}")
    public Pengguna getById(@PathVariable Long id) {
        return penggunaService.getById(id);
    }

    @PostMapping
    public Pengguna create(@RequestBody Pengguna pengguna) {
        return penggunaService.create(pengguna);
    }

    @PutMapping("/{id}")
    public Pengguna update(@PathVariable Long id, @RequestBody Pengguna pengguna) {
        return penggunaService.update(id, pengguna);
    }

    @DeleteMapping("/{id}")
    public Pengguna delete(@PathVariable Long id) {
        return penggunaService.delete(id);
    }
}
