package com.Ezzarhmouti.tp_spring.controller;
import com.Ezzarhmouti.tp_spring.model.Patient;
import com.Ezzarhmouti.tp_spring.model.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class PatientsController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping(path = "/index")
    public String test(Model model,
                       @RequestParam(name="motCle",defaultValue="") String mc,
                       @RequestParam(name="page",defaultValue="0") int page,
                       @RequestParam(name="size",defaultValue="5") int size)
    {
        Page<Patient> patientsPage = patientRepository.findByNomContains(mc, PageRequest.of(page,size));
        List<Patient> patients = patientsPage.getContent();
        model.addAttribute("listePatients", patients);
        model.addAttribute("motCle", mc);
        model.addAttribute("nbrPage",patientsPage.getTotalPages());
        model.addAttribute("pages",new int[patientsPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("size",size);
        return "index";
    }
    @GetMapping(path="/add")
    public String addPatient(Model model){
        model.addAttribute("patient",new Patient());
        return  "form";
    }
    @PostMapping("savePatient")
    public String savePatient(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "form";
        patientRepository.save(patient);
        System.out.println(patient);
        return "redirect:/index";
    }
    @GetMapping(path="/updatePatient")
    public String updatePatient(@RequestParam(name = "id") Long id, Model model){
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isEmpty())
            return "redirect:/index";
        model.addAttribute("patient", patient.get());
        return  "update";
    }
    @PostMapping("/updatePatient")
    public String updatePatientForm(@RequestParam(name = "id") Long id, @ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "update";
        Optional<Patient> oPatient = patientRepository.findById(id);
        if (oPatient.isEmpty())
            return "redirect:/index";
        Patient p = oPatient.get();
        p.setNom(patient.getNom());
        p.setDateNaissance(patient.getDateNaissance());
        p.setScore(patient.getScore());
        p.setMalade(patient.isMalade());
        patientRepository.save(p);
        return "redirect:/index";
    }
    @GetMapping(path="/deletePatient")
    public String delete(Long id,String motCle,int page,int size) {
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&motCle="+motCle+"&size="+size;
    }
}
