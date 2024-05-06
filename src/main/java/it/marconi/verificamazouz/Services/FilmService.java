package it.marconi.verificamazouz.Services;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import it.marconi.verificamazouz.Controllers.FilmController;
import it.marconi.verificamazouz.Domains.AttributiFIlm;
import it.marconi.verificamazouz.Domains.AttributiFIlm.RegistrationForm;

public class FilmService {
    // creo l'arrayList
    private ArrayList<AttributiFIlm> films = new ArrayList<>();

    public ArrayList<AttributiFIlm> getFIlms() {
        return films;
    }

    //metodo aggiunta film
    public void addFilm(AttributiFIlm newFIlm) {
        films.add(newFIlm);
    }

        public Optional<AttributiFIlm> getFilmByTitolo(String titolo) {

        for(AttributiFIlm f : films) {
            if(f.getTitolo().equals(titolo)) {
                return Optional.of(f);
            }
        }
        return Optional.empty();
    }

    /*
     * Metodo per aggiungere un film
     */
    public void addRandomFilm(int numeroFilms) {
        Random random = new Random();

        for (int i = 0; i < numeroFilms; i++) {
            String titolo = "Film" + (films.size() + 1);
            int anno = random.nextInt(2023 - 1900);
            String genere = getRandomGenre(random);
            

            AttributiFIlm film = new AttributiFIlm(titolo, anno,genere);
            films.add(film);
        }
    }

        /*
         * Prova aggiunta dei film
         */
        private String getRandomGenre(Random random) {
        String[] genere = {"Action", "Mafia", "Commedia", "Fanatasy"};
        return genere[random.nextInt(genere.length)];
    }
       
}
