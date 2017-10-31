package lab.aikibo.cobaspringweb.repo;

import lab.aikibo.cobaspringweb.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tamami <tamami.oka@gmail.com>
 */
@Repository
public interface MahasiswaRepo extends JpaRepository<Mahasiswa, String> {
    public Mahasiswa findByNim(String nim);
}
