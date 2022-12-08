package penjualan.transaksi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import penjualan.transaksi.model.Kecamatan;

/**
 *
 * @author MSI-JO
 */
@Repository
public interface KecamatanRepository extends JpaRepository<Kecamatan, Long>{
    Optional<Kecamatan> findByName(String name); 
}
