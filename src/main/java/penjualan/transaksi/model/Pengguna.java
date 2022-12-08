package penjualan.transaksi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pengguna")
public class Pengguna {
    

  @Id
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  private Boolean isEnabled;
  private Boolean isAccountLocked;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @OneToOne
  @MapsId
  @JoinColumn(name = "id")
  private Karyawan karyawan;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
    name = "tb_pengguna_peran",
    joinColumns = @JoinColumn(name = "pengguna_id"),
    inverseJoinColumns = @JoinColumn(name = "peran_id")
  )
  private List<Peran> perans;

    public void setKaryawan(Karyawan karyawan) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public Object getKaryawan() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setPeran(List<Peran> perans) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
