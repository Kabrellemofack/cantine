package cantine.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cantine.dao.DaoUnite;
import cantine.data.Unite;
import cantine.util.Alert;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RolesAllowed("ADMIN")
@RequestMapping("/unite")
public class WebUnite {

    private final DaoUnite daoUnite;

    // ------- listContent()

    @PostMapping("/list/content")
    public String getListContent(Model model) {
        var list = daoUnite.findAll();
        model.addAttribute("list", list);
        return "unite/list :: #dynamic_view";
    }

    // ------- list()

    @GetMapping("/list")
    public String list(Model model) {
        getListContent(model);
        return "unite/list";
    }

    // ------- edit()

    @GetMapping("/form")
    public String edit(Long id, Model model) {
        Unite item;
        if (id == null) {
            item = new Unite();
        } else {
            item = daoUnite.findById(id).orElse(new Unite());
        }
        model.addAttribute("item", item);
        return "unite/form";
    }

    // ------- save()

    @PostMapping("/form")
    public String save(Unite item, RedirectAttributes ra) {
        daoUnite.save(item);
        ra.addFlashAttribute("alert", new Alert(Alert.Color.SUCCESS, "Mise à jour effectuée avec succès"));
        return "redirect:/unite/list";
    }

    // ------- delete()

    @PostMapping("/delete")
    public String delete(Long id, Model model) {
        daoUnite.deleteById(id);
        model.addAttribute("alert", new Alert(Alert.Color.SUCCESS, "Suppression effectuée avec succès"));
        return getListContent(model);
    }
}
