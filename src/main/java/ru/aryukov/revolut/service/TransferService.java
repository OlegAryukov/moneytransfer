package ru.aryukov.revolut.service;

/**
 * Created by oaryukov on 20.10.2018.
 */
public interface TransferService {

    void makeDraft(long bankAccIdFrom, long bankAccIdTo, double summ);

    void makeDraftWithExchange(long bankAccIdFrom, long bankAccIdTo,
                               String currTypeFrom, String currTypeTo,
                               double summ);
}
