package it.marconi.verificamazouz.Controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import it.marconi.verificamazouz.Domains.AttributiFIlm;
import it.marconi.verificamazouz.Services.FilmService;

@Controller
@RequestMapping("/films")
public class FilmController {
    @Autowired
    FilmService FilmService;

    @GetMapping("/new")
    public ModelAndView newFilmForm() {
        return new ModelAndView("film-form").addObject(new AttributiFIlm());
    }

    @GetMapping("/films")
    public ModelAndView handlerUserAction(@RequestParam("type") String type) {

        // in base al parametro, mostro la pagina relativa
        if(type.equals("new"))
            return new ModelAndView("inserimento-film").addObject("filmForm", new AttributiFIlm());

        // se il parametro è errato, pagina non trovata
        else 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagina non trovata!");
    }

    @PostMapping("/films/new")
    public ModelAndView handlerNewFilm(@ModelAttribute AttributiFIlm FilmForm) {

        // salvo l'utente nel "database"
        FilmService.addFilm(FilmForm);

        String film = FilmForm.getTitolo();         
        return new ModelAndView("redirect:/films/" + film);
    }

    @GetMapping("/films/{codice}")
    public String mostraDettagli(@PathVariable  String codice, Model model) {
        model.addAttribute("film", FilmService.getFIlms());
        return "filmDetails";
    }
}

