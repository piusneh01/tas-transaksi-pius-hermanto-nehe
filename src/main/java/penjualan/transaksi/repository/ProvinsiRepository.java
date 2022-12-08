package penjualan.transaksi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import penjualan.transaksi.model.Provinsi;

@Repository
public interface ProvinsiRepository extends JpaRepository<Provinsi, Long> {
    Boolean existsByName(String name);
}
