package penjualan.transaksi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import penjualan.transaksi.model.Karyawan;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Long>{
    
}
