package junit;

import com.example.foodo.engineering.dao.RecipeDAO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAverage {

     /* FLAVIO CAMPOBASSO
        il seguente test verifica che quando viene inserita una recensione (media)
        nuova, il valore della media della ricetta sia effettivamente aggiornato.
     */

    @Test
    void testAverage(){

        RecipeDAO recipeDAO = new RecipeDAO();
        float average1 = 0;
        float average2 = 0;
        average1 = recipeDAO.setAverage("Tiramisù", "carlo");
        System.out.print(average1);
        float value = (average1+2)/2;
        recipeDAO.setReview(value, "Tiramisù");
        average2 = recipeDAO.setAverage("Tiramisù", "carlo");
        assertEquals(average1, average2);//il test fallisce perche la nuova media è diversa da quella precedente
    }

}
