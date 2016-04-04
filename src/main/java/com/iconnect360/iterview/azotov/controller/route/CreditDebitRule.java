package com.iconnect360.iterview.azotov.controller.route;

import com.iconnect360.iterview.azotov.controller.provider.Processor;

/**
 * Created by alexey.zotov on 3/31/2016.
 */
public abstract class CreditDebitRule implements RoutingRule {
    protected Processor debitCardProcessor;
    protected Processor creditCardProcessor;

    public Processor getDebitCardProcessor() {
        return debitCardProcessor;
    }

    public void setDebitCardProcessor(Processor debitCardProcessor) {
        this.debitCardProcessor = debitCardProcessor;
    }

    public Processor getCreditCardProcessor() {
        return creditCardProcessor;
    }

    public void setCreditCardProcessor(Processor creditCardProcessor) {
        this.creditCardProcessor = creditCardProcessor;
    }
}
