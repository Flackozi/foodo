package junit;

import com.example.foodo.controllerappl.SearchRecipeController;
import com.example.foodo.engineering.bean.SearchRecipeBean;
import com.example.foodo.engineering.exception.RecipeNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSearchRecipeController {

    /*CARLO MARIA FIORAMANTI
    Il seguente test serve a verificare che venga sollevata un eccezione nel momento in cui
    viene eseguita una ricerca di una ricetta il cui nome non corrisponde a nessuna delle ricette
     */

    @Test
    void testSearchRecipe(){
        int validRecipe=0;
        SearchRecipeBean searchRecipeBean= new SearchRecipeBean("1234");
        SearchRecipeController searchRecipeController= new SearchRecipeController();
        try{
            searchRecipeController.searchRecipe(searchRecipeBean);
            validRecipe=1;
        }catch (RecipeNotFoundException e){
            validRecipe=2;
        } catch (Exception ignored){

        }
        assertEquals(2, validRecipe); //il test ha successo perché il nome della ricetta non corrisponde a nessuna
    }


}
