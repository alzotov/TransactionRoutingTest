package com.iconnect360.iterview.azotov.controller.route;

import com.iconnect360.iterview.azotov.controller.provider.Processor;
import com.iconnect360.iterview.azotov.model.CardTransactionRz;

/**
 * Created by alexey.zotov on 3/31/2016.
 */
public interface RoutingRule {

    public Processor select(CardTransactionRz trx) throws Exception;

}