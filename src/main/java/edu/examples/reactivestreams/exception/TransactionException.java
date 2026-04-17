package edu.examples.reactivestreams.exception;

import edu.examples.reactivestreams.model.Txn;

public class TransactionException extends RuntimeException {

    private final Txn txn;

    public TransactionException(Txn txn) {
        super("Transaction " + txn.getId() + " failed due to " + txn.getErrorReason());
        this.txn = txn;
    }

    public Txn getTxn() {
        return this.txn;
    }

}
