package cantine.web;

import cantine.dao.DaoPlat;
import cantine.data.Plat;
import cantine.util.Alert;
import cantine.util.Paging;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RolesAllowed("ADMIN")
@RequestMapping("/plat")
@SessionAttributes("pagingPlat")
public class WebPlat {

    // DAO pour accéder aux données des plats
    private final DaoPlat daoPlat;

    /**
     * Affiche la liste des plats (page principale)
     */
    @GetMapping("/list")
    public String list(Paging paging, Model model) {
        getListContent(paging, model);
        return "plat/list";
    }

    /**
     * Recharge le contenu de la liste en fonction de la pagination (appelé via AJAX ou formulaire)
     */
    @PostMapping("/list/content")
    public String getListContent(Paging paging, Model model) {
        var page = getPage(paging);

        // Si la page demandée dépasse le total, on ajuste
        if (paging.getPageNum() > page.getTotalPages() && page.getTotalPages() > 0) {
            paging.setPageNum(page.getTotalPages());
            page = getPage(paging);
        }

        // On ajoute les données à afficher dans la page
        model.addAttribute("list", page.getContent());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("totalPages", page.getTotalPages());

        // On retourne juste la partie dynamique (fragment Thymeleaf)
        return "plat/list :: #dynamic_view";
    }

    /**
     * Affiche le formulaire d'ajout ou de modification d'un plat
     */
    @GetMapping("/form")
    public String edit(Long id, Model model) {
        Plat item = (id == null) ? new Plat() : daoPlat.findById(id).get();
        model.addAttribute("item", item);
        return "plat/form";
    }

    /**
     * Sauvegarde d’un plat (ajout ou modification)
     */
    @PostMapping("/form")
    public String save(Plat item, RedirectAttributes ra) {
        daoPlat.save(item);
        ra.addFlashAttribute("alert", new Alert(Alert.Color.SUCCESS, "Mise à jour effectuée avec succès"));
        return "redirect:/plat/list";
    }

    /**
     * Supprime un plat par son identifiant
     */
    @PostMapping("/delete")
    public String delete(Long id, Paging paging, Model model) {
        daoPlat.deleteById(id);
        model.addAttribute("alert", new Alert(Alert.Color.SUCCESS, "Suppression effectuée avec succès"));
        return getListContent(paging, model);
    }

    /**
     * Méthode utilitaire pour récupérer une page de plats
     */
    private Page<Plat> getPage(Paging paging) {
        var pageable = PageRequest.of(paging.getPageNum() - 1, paging.getPageSize());
        return daoPlat.findAll(pageable);
    }

    /**
     * Pour réinitialiser la session si besoin
     */
    @PostMapping("/cancel")
    public String cancel(SessionStatus status) {
        status.setComplete();
        return "redirect:/plat/list";
    }
}
