package penjualan.transaksi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_karyawan")
public class Karyawan {//Profile

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "karyawan_name")
  private String name;

  @Column(nullable = false, unique = true, name = "karyawan_email")
  private String email;

  @Column(length = 13)
  private Long phone;

  @OneToOne(mappedBy = "karyawan", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private Pengguna pengguna;
}
