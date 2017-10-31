package lab.aikibo.cobacrudangular.repo;

import lab.aikibo.cobacrudangular.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tamami <tamami.oka@gmail.com>
 */
@Repository
public interface MahasiswaRepo extends JpaRepository<Mahasiswa, String> {
   
}
