package lab.aikibo.cobacrudangular.controller;

import java.util.List;
import lab.aikibo.cobacrudangular.entity.Mahasiswa;
import lab.aikibo.cobacrudangular.repo.MahasiswaRepo;
import lab.aikibo.cobacrudangular.repo.MahasiswaRepoPaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tamami <tamami.oka@gmail.com>
 */
@RestController
public class ApiRestController {
    
    @Autowired
    private MahasiswaRepo mhsRepo;
    
    @Autowired
    private MahasiswaRepoPaging mhsRepoPaging;
    
    @RequestMapping("/daftar-mahasiswa")
    public List<Mahasiswa> getDaftarMahasiswa() {
        return mhsRepo.findAll();
    }
    
    @RequestMapping("/daftar-mahasiswa-with-paging")
    public Page<Mahasiswa> getDaftarMahasiswaWithPaging(Pageable pageable) {
        return mhsRepoPaging.findAll(pageable);
    }
    
    @RequestMapping(value = "/tambah-data", method = RequestMethod.POST) 
    public void tambahData(@RequestBody Mahasiswa mhs) {
        mhsRepo.save(mhs);
    }    
    
    @RequestMapping(value = "/get-mahasiswa-by-nim/{nim}")
    public Mahasiswa getMahasiswaByNim(@PathVariable("nim") String nim) {
        return mhsRepo.findOne(nim);
    }
    
    @RequestMapping(value = "/simpan-edit-data", method = RequestMethod.POST)
    public void simpanEditData(@RequestBody Mahasiswa mhs) {
        mhsRepo.save(mhs);
    }
    
    @RequestMapping(value = "/hapus/{nim}", method = RequestMethod.DELETE)
    public void deleteData(@PathVariable("nim") String nim) {
        mhsRepo.delete(nim);
    }
}
