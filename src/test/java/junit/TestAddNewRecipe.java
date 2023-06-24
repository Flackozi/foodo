package junit;

import com.example.foodo.controllerappl.RecipeController;
import com.example.foodo.engineering.bean.RecipeBean;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAddNewRecipe {

    /*CARLO MARIA FIORAMANTI
    questo test si occupa di verificare se l'inserimento di una ricetta vada a buon fine.
    Il metodo che salva la ricetta è saveRecipe e restituisce il recipeId della ricetta, quando l'inserimento va a buon
    fine, -1 se questo falliscce.
     */

    @Test
    void TestAddRecipe(){
        try{

            RecipeBean recipeBean= new RecipeBean("biscotti", "...", "carlo","C:\\Users\\carlo\\Desktop\\PROGETTO_ISPW\\foodo\\src\\main\\resources\\image\\pancake.jpeg");
            RecipeController recipeController= new RecipeController();

            int recipeId=recipeController.saveRecipe(recipeBean);

            // il test fallisce perché l'inserimento va a buon fine
            assertEquals(-1, recipeId);
        }catch(Exception ignored){

        }
    }
}
