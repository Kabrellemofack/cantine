package cantine.web;

import cantine.dao.DaoIngredient;
import cantine.dao.DaoUnite;
import cantine.data.Ingredient;
import cantine.data.Unite;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ingredient")
public class WebIngredient {

    @Autowired
    private DaoIngredient daoIngredient;

    @Autowired
    private DaoUnite daoUnite;

    @GetMapping
    public String list(Model model) {
        Iterable<Ingredient> ingredients = daoIngredient.findAll();
        model.addAttribute("ingredients", ingredients);
        return "ingredient/list";
    }

   /** @GetMapping("/edit")
    public String edit(@RequestParam(required = false) Integer id, Model model) {
        Ingredient ingredient = (id == null) ? new Ingredient() : daoIngredient.findAllById(id);
        model.addAttribute("item", ingredient);
        model.addAttribute("unites", daoUnite.findAll());
        return "ingredient/form";
    }*/

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("item") Ingredient ingredient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("unites", daoUnite.findAll());
            return "ingredient/form";
        }
        daoIngredient.save(ingredient);
        return "redirect:/ingredient";
    }

    /**@GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        daoIngredient.deleteById(id);
        return "redirect:/ingredient";
    }*/
}
