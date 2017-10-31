package lab.aikibo.cobaspringweb.controller;

import lab.aikibo.cobaspringweb.entity.Mahasiswa;
import lab.aikibo.cobaspringweb.repo.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author tamami <tamami.oka@gmail.com>
 */
@Controller
public class AppController {
    
    @Autowired
    private MahasiswaRepo mhsRepo;
    
    @RequestMapping("/home")
    public void index() {}
    
    @RequestMapping("/daftar-mahasiswa") 
    public void getDaftarMahasiswa(Model model) {
        model.addAttribute("daftarMahasiswa", mhsRepo.findAll());
    }
    
    @RequestMapping(value = "/tambah-data", method = RequestMethod.GET)
    public void getTambahData(@ModelAttribute("mhs")Mahasiswa mhs, 
            BindingResult binding) {
    }
    
    @RequestMapping(value = "/tambah-data", method = RequestMethod.POST) 
    public String saveTambahData(@ModelAttribute("mhs")Mahasiswa mhs,
            BindingResult binding) {
        System.out.println(mhs.getNim());
        mhsRepo.save(mhs);
        return "redirect:/daftar-mahasiswa";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public void getEditData(@RequestParam(name = "nim", required = false) String nim, 
    	@ModelAttribute("mhs") Mahasiswa mahasiswa, BindingResult binding) {
    	Mahasiswa mhs = mhsRepo.findByNim(nim);
    	mahasiswa.setNim(mhs.getNim());
    	mahasiswa.setNama(mhs.getNama());
    	mahasiswa.setJurusan(mhs.getJurusan());
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditData(@ModelAttribute("mhs") Mahasiswa mhs, 
    		BindingResult binding) {
    	mhsRepo.save(mhs);
    	return "redirect:/daftar-mahasiswa";
    }

    @RequestMapping("/delete")
    public String deleteData(@RequestParam(name = "nim", required = true) String nim) {
    	mhsRepo.delete(nim);
    	return "redirect:/daftar-mahasiswa";
    }
    
}


