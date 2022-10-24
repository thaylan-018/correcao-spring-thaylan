package thaylanvinicius.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import thaylanvinicius.models.Professor;
import thaylanvinicius.repositories.ProfessoresRepository;

@Controller
@RequestMapping("/professores")
public class ProfessoresController {
    @Autowired
    private ProfessoresRepository professoresRepo;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("professores", this.professoresRepo.findAll());
        return "list";
    }

    @RequestMapping("update/{id}")
    public String update(Model model, @PathVariable int id) {
        Optional <Professor> professor =  professoresRepo.findById(id);
        model.addAttribute(" professor",  professor.get());
        return "/ professores/update";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String saveInsert(@RequestParam("nome") String nome, @RequestParam("idade") int idade, @RequestParam("componente") String componente) {
        Professor  professor = new  Professor();
        professor.setNome(nome);
        professor.setComponente(componente);
        professoresRepo.save(professor);
        return "redirect:/ professores/list";
    }

    @RequestMapping("insert")
    public String insert() {
        return "/ professores/insert";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String saveUpdate(@RequestParam("nome") String nome, @RequestParam("idade") int idade, @RequestParam("id") int id, @RequestParam ("componente") String componente) {
        Optional<Professor> professor =  professoresRepo.findById(id);
        professor.get().setNome(nome);
        professor.get().setComponente(componente);
        professoresRepo.save(professor.get());
        return "redirect:/professores/list";
    }

    @RequestMapping("delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        Optional < Professor>  professor =  professoresRepo.findById(id);
        model.addAttribute(" professor",  professor.get());
        return "/ professores/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String saveDelete(@RequestParam("id") int id) {
        professoresRepo.deleteById(id);
        return "redirect:/ professores/list";
    }
}
