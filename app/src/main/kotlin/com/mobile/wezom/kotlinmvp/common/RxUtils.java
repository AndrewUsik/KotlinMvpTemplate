package com.mobile.wezom.kotlinmvp.common;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class RxUtils {

    /**
     * {@link ObservableTransformer} that transforms the source observable to subscribe in the
     * io thread and observe on the Android's UI thread.
     */
    private static ObservableTransformer ioToMainThreadSchedulerTransformer;

    static {
        ioToMainThreadSchedulerTransformer = createIOToMainThreadScheduler();
    }

    /**
     * Get {@link ObservableTransformer} that transforms the source observable to subscribe in
     * the io thread and observe on the Android's UI thread.
     *
     * Because it doesn't interact with the emitted items it's safe ignore the unchecked casts.
     *
     * @return {@link ObservableTransformer}
     */
    @SuppressWarnings("unchecked")
    private static <T> ObservableTransformer<T, T> createIOToMainThreadScheduler() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @SuppressWarnings("unchecked")
    public static <T> ObservableTransformer<T, T> applyIOToMainThreadSchedulers() {
        return ioToMainThreadSchedulerTransformer;
    }
}