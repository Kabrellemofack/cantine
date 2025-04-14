package cantine.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cantine.dao.DaoPlat;
import cantine.dao.DaoTypePlat;
import cantine.data.Plat;
import cantine.util.Alert;
import cantine.util.Paging;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RolesAllowed( "ADMIN" )
@RequestMapping( "/plat" )
@SessionAttributes( "pagingPlat" )
public class WebPlat {

	// -------
	// Composants injectés
	// -------

	private final DaoPlat		daoPlat;
	private final DaoTypePlat		daoTypePlat;

	// -------
	// Attributs de session
	// -------

	@ModelAttribute
	public Paging getPaging( @ModelAttribute( "pagingPlat" ) Paging paging ) {
		return paging;
	}

	// -------
	// Endpoints
	// -------

	// -------
	// listContent()

	@PostMapping( "/list/content" )
	public String getListContent( Paging paging, Model model ) {

		var page = getPage( paging );
		
		// Si la n° de page demandé est > au nombre total, on affiche la dernière page 
		if ( paging.getPageNum() > page.getTotalPages() && page.getTotalPages() > 0 ) {
			paging.setPageNum( page.getTotalPages() );
			page = getPage( paging );
		}

		model.addAttribute( "list", page.getContent() );
		model.addAttribute( "totalItems", page.getTotalElements() );
		model.addAttribute( "totalPages", page.getTotalPages() );
		return "plat/list :: #dynamic_view";

	}

	// -------
	// list() - GET
 
	@GetMapping( "/list" )
	public String list( Paging paging, Model model ) {
		getListContent( paging, model );
		return "plat/list";
	}

	// -------
	// list() - POST

	@PostMapping( "/list" )
	public String list() {
		return "redirect:/plat/list";
	}

	// -------
	// edit()

	@GetMapping( path = "/form" )
	public String edit( Long id, Model model ) {

		Plat item;
		if ( id == null ) {
			item = new Plat();
		} else {
			item = daoPlat.findById( id ).get();
		}

		model.addAttribute( "item", item );
		model.addAttribute("typePlats", daoTypePlat.findAll());

		return "plat/form";

	}

	// -------
	// save()

	@PostMapping("/form")
	public String save(
	    @ModelAttribute("item") Plat item,
	    BindingResult result,
	    Model model,
	    RedirectAttributes ra) {

	    
	    boolean nomUnique = daoPlat.verifierUniciteNom(item.getNom(), item.getIdPlat());

	    if (nomUnique) {
	        daoPlat.save(item);
	        ra.addFlashAttribute("alert", new Alert(Alert.Color.SUCCESS, "Mise à jour effectuée avec succès"));
	        return "redirect:/plat/list";
	    } else {
	        
	        result.rejectValue("nom", "", "Ce nom est déjà utilisé");
	        model.addAttribute("types", daoTypePlat.findAll()); 
	        return "plat/form"; 
	    }
	}


	// -------
	// delete()

	@PostMapping( "/delete" )
	public String delete( Long id, Paging paging, Model model ) {

		daoPlat.deleteById( id );
		model.addAttribute( "alert", new Alert( Alert.Color.SUCCESS, "Suppression effectuée avec succès" ) );
		return getListContent( paging, model );

	}

	// -------
	// Méthodes auxiliaires
	// ------
	private Page<Plat> getPage(Paging paging) {
	    var pageable = PageRequest.of(paging.getPageNum() - 1, paging.getPageSize(), Sort.by("nom"));

	    String rechercher = paging.getSearch();

	    if (rechercher == null || rechercher.isEmpty()) {
	        return daoPlat.findAll(pageable); 
	    } else {
	        return daoPlat.findByNomContaining(rechercher, pageable);  
	    }
	}



}