import com.iconnect360.iterview.azotov.controller.TransactionProcessor;
import com.iconnect360.iterview.azotov.model.Card;
import com.iconnect360.iterview.azotov.model.CardTransaction;
import com.iconnect360.iterview.azotov.model.CardTransactionRz;

/**
 * Created by alexey.zotov on 3/31/2016.
 */
public class Main {

    public static void main(String... params) throws Exception {
        TransactionProcessor p = new TransactionProcessor();

        CardTransaction t = new CardTransaction();
        Card c = new Card();
        t.setCard(c);
        c.setCardNumber("431940");
        CardTransactionRz rz = p.process(t);
    }
}
