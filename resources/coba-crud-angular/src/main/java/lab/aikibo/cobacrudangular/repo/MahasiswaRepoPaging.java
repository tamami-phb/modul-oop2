package lab.aikibo.cobacrudangular.repo;

import lab.aikibo.cobacrudangular.entity.Mahasiswa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tamami <tamami.oka@gmail.com>
 */
@Repository
public interface MahasiswaRepoPaging extends PagingAndSortingRepository<Mahasiswa, String> {
    
    
    
    
}
