package penjualan.transaksi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import penjualan.transaksi.model.Pengguna;

/**
 *
 * @author MSI-JO
 */
@Repository
public interface PenggunaRepository extends JpaRepository<Pengguna, Long>{
    Optional<Pengguna> findByUsername(String username);
    // SELECT * FROM USER WHERE USERNAME = ?
}
