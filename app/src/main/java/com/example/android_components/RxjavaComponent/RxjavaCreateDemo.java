package com.example.android_components.RxjavaComponent;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class RxjavaCreateDemo {



        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(@NonNull ObservableEmitter emitter) throws Throwable {
                for (int i = 0; i < 5; i++) {
                    emitter.onNext("runing" + i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                emitter.onComplete();
            }
        });

        Observer o = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribed");
            }

            @Override
            public void onNext(Object o) {
                System.out.println(o.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        };

}
