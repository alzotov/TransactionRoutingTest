/**
 * Created by alexey.zotov on 3/31/2016.
 */

import com.iconnect360.iterview.azotov.controller.TransactionProcessor;
import com.iconnect360.iterview.azotov.model.Card;
import com.iconnect360.iterview.azotov.model.CardTransaction;
import com.iconnect360.iterview.azotov.model.CardTransactionRz;
import com.iconnect360.iterview.azotov.model.CardType;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class TransactionProcessorTest {
    @Test
    public void DebitTest1() throws Exception {
        System.out.println("Testing Credit BIN");
        TransactionProcessor p = new TransactionProcessor();
        CardTransaction t = new CardTransaction();
        Card c = new Card();
        c.setName("-");
        c.setExpiry(new Date());
        c.setCvv("-");
        t.setCard(c);
        c.setCardNumber("431940XXXXXXXX");
        System.out.println(t);
        CardTransactionRz rz = p.process(t);
        System.out.println(rz);
        assertEquals(CardType.DEBIT,rz.getCardType());
    }

    @Test
    public void CreditTest1() throws Exception {
        System.out.println("Testing Credit BIN");
        TransactionProcessor p = new TransactionProcessor();
        CardTransaction t = new CardTransaction();
        Card c = new Card();
        c.setName("ALEXEY ZOTOV");
        c.setExpiry(new GregorianCalendar(1972,9,5).getTime());
        c.setCvv("***");
        t.setCard(c);
        c.setCardNumber("540788");
        System.out.println(t);
        CardTransactionRz rz = p.process(t);
        System.out.println(rz);
        assertEquals(CardType.CREDIT,rz.getCardType());
    }

    //@Test(expected=java.io.FileNotFoundException.class)
    @Test(expected=Exception.class)
    public void BadNumberTest() throws Exception {
        System.out.println("Testing Exception");
        TransactionProcessor p = new TransactionProcessor();
        CardTransaction t = new CardTransaction();
        Card c = new Card();
        t.setCard(c);
        c.setCardNumber("000000");
        CardTransactionRz rz = p.process(t);
    }

}