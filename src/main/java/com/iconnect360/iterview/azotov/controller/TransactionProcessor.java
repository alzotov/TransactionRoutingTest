package com.iconnect360.iterview.azotov.controller;

import com.iconnect360.iterview.azotov.controller.route.impl.BINRule;
import com.iconnect360.iterview.azotov.controller.route.CreditDebitRule;
import com.iconnect360.iterview.azotov.controller.provider.impl.CreditCardProcessor;
import com.iconnect360.iterview.azotov.controller.provider.impl.DebitCardProcessor;
import com.iconnect360.iterview.azotov.controller.provider.Processor;
import com.iconnect360.iterview.azotov.model.CardTransaction;
import com.iconnect360.iterview.azotov.model.CardTransactionRz;

/**
 * Created by alexey.zotov on 3/31/2016.
 * This class simulates routing of the banking card processing, based on properties of the card, such as card number
 */
public class TransactionProcessor {

    private final CreditCardProcessor creditProcessor;
    private final DebitCardProcessor debitProcessor;
    private final CreditDebitRule binRule;

    public TransactionProcessor(){
        creditProcessor = new CreditCardProcessor();
        debitProcessor = new DebitCardProcessor();

        binRule = new BINRule();
        binRule.setDebitCardProcessor(debitProcessor);
        binRule.setCreditCardProcessor(creditProcessor);
        }

        public CardTransactionRz process(CardTransaction trxIn) throws Exception {
            CardTransactionRz trxOut = new CardTransactionRz(trxIn);
            Processor provider = binRule.select(trxOut);
            provider.process(trxOut);
            System.out.println("Processing finished");
            return trxOut;
        }

}