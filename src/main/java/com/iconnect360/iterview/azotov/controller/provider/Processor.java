package com.iconnect360.iterview.azotov.controller.provider;

import com.iconnect360.iterview.azotov.model.CardTransactionRz;

/**
 * Created by alexey.zotov on 3/31/2016.
 */
public interface Processor {
    public CardTransactionRz process(CardTransactionRz trx);
}
