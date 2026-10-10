package edu.examples.reactivestreams.repository;

import edu.examples.reactivestreams.model.Account;
import edu.examples.reactivestreams.model.TxnEntry;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Update;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
    @Query("{accountNum:'?0'}")
    Mono<Account> findByAccountNum(String accountNum);

    @Update("{'$inc':{'balance': ?1}}")
    Mono<Long> findAndIncrementBalanceByAccountNum(String accountNum, double increment);

    @Query("{ 'accountNum' : ?0 }")
    Flux<TxnEntry> findByTxnByAccount(String accountNum);
}
