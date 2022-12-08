
package penjualan.transaksi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import penjualan.transaksi.model.Peran;

/**
 *
 * @author MSI-JO
 */
@Repository
public interface PeranRepository extends JpaRepository<Peran, Long>{
    
}
