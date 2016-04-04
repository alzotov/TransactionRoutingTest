package com.iconnect360.iterview.azotov.controller.provider.impl;

import com.iconnect360.iterview.azotov.controller.provider.Processor;
import com.iconnect360.iterview.azotov.model.CardTransactionRz;

/**
 * Created by alexey.zotov on 3/31/2016.
 */
public class DebitCardProcessor implements Processor {

    public CardTransactionRz process(CardTransactionRz trx)
    {
        System.out.println("Debit Card processing");
        trx.setCode("0");
        trx.setDescription("Success");
        return trx;
    }
}
