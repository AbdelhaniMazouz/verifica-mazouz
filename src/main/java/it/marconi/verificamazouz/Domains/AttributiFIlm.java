package it.marconi.verificamazouz.Domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributiFIlm {

    private String codice;
    private String titolo;
    private String genere;
    private String anno;
    private int voto;

}
