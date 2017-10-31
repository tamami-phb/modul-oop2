package lab.aikibo.cobacrudangular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tamami <tamami.oka@gmail.com>
 */
@Entity
public class Mahasiswa {
    
    @Id @Getter @Setter
    private String nim;
    
    @Column @Getter @Setter
    private String nama;
    
    @Column @Getter @Setter
    private String jurusan;
    
}
