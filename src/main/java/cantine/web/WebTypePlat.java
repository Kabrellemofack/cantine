package cantine.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cantine.dao.DaoTypePlat;
import cantine.data.TypePlat;
import cantine.util.Alert;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RolesAllowed( "ADMIN" )
@RequestMapping( "/typePlat" )
public class WebTypePlat {

	// -------
	// Composants injectés
	// -------

	private final DaoTypePlat daoTypePlat;

	// -------
	// Endpoints
	// -------

	// -------
	// listContent()

	@PostMapping( "/list/content" )
	public String getListContent( Model model ) {

		var list = daoTypePlat.findAll();
		model.addAttribute( "list", list );
		return "typePlat/list :: #dynamic_view";

	}

	// -------
	// list()

	@GetMapping( "/list" )
	public String list( Model model ) {
		getListContent( model );
		return "typePlat/list";
	}

	// -------
	// edit()

	@GetMapping( path = "/form" )
	public String edit( Long id, Model model ) {

		TypePlat item;
		if ( id == null ) {
			item = new TypePlat();
		} else {
			item = daoTypePlat.findById( id ).get();
		}

		model.addAttribute( "item", item );
		return "typePlat/form";

	}

	// -------
	// save()

	@PostMapping( "/form" )
	public String save(
			TypePlat item,
			RedirectAttributes ra ) {

		daoTypePlat.save( item );

		ra.addFlashAttribute( "alert", new Alert( Alert.Color.SUCCESS, "Mise à jour effectuée avec succès" ) );
		return "redirect:/typePlat/list";

	}

	// -------
	// delete()

	@PostMapping( "/delete" )
	public String delete( Long id, Model model ) {

		daoTypePlat.deleteById( id );
		model.addAttribute( "alert", new Alert( Alert.Color.SUCCESS, "Suppression effectuée avec succès" ) );

		return getListContent( model );

	}

}
