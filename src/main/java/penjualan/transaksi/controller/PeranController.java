
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
import penjualan.transaksi.model.Peran;
import penjualan.transaksi.service.PeranService;

/**
 *
 * @author MSI-JO
 */
@RestController
@AllArgsConstructor
@RequestMapping("/peran")
public class PeranController {
    
    private PeranService peranService;
    
    @GetMapping
    public List<Peran> getAll() {
        return peranService.getAll();
    }

    @GetMapping("/{id}")
    public Peran getById(@PathVariable Long id) {
      return peranService.getById(id);
    }

    @PostMapping
    public Peran create(@RequestBody Peran peran) {
        return peranService.create(peran);
    }

    @PutMapping("/{id}")
    public Peran update(@PathVariable Long id, @RequestBody Peran peran) {
       return peranService.update(id, peran);
    }

    @DeleteMapping("/{id}")
    public Peran delete(@PathVariable Long id) {
      return peranService.delete(id);
    }
    
}
