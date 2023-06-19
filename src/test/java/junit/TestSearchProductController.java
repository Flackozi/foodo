package junit;
import com.example.foodo.controllerappl.SearchProductController;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.SearchBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.exception.ProductNotFoundException;
import com.example.foodo.engineering.session.Session;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestSearchProductController {

    /* FLAVIO CAMPOBASSO
    il seguente test verifica che venga solletava un exception
    quando viene cercato un prodotto non presente nella dispensa o
    non esistente.
     */

    @Test
    void testSearchProduct(){
        int validProduct=0;
        UserBean userBean = new UserBean("flavio", "pizza", "mediterrnean", 2, "C:\\Users\\flavi\\Pictures\\Screenshots\\Screenshot_20221106_124938.png");
        Session.setSessionInstance(userBean);
        SearchBean searchBean = new SearchBean("pallone", true, false, false, false, false, false, false);
        SearchProductController searchProductController = new SearchProductController();
        try{
            searchProductController.searchProduct(searchBean);
            validProduct = 1;
        }catch(ProductNotFoundException e){
            validProduct = 2;
        }catch (Exception ignored){
        }

        assertEquals(2, validProduct);
    }
}
