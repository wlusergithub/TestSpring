package com.unjlams.SpringAop;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by UnjlAms on 2017/9/24.
 */

//事务类
public class TransationServices {

    private FirstTransation ts;
    private TransactionTemplate tt;

    public void setTt(TransactionTemplate tt) {
        this.tt = tt;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
    public void services(final Integer from, final Integer to, final double money) {
//        tt.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
        ts.decreaseMoney(money, from);

//                int i = 1/0;

        ts.increaseMoney(money, to);
//            }
//        });

    }


    public void setTs(FirstTransation ts) {
        this.ts = ts;
    }
}
