package ir.jahanshahloo.evmis.Util;

import android.content.Context;

import javax.inject.Inject;

import ir.jahanshahloo.evmis.Service.Handler.Handlers;

/**
 * Created by Ali on 10/13/16.
 */
public enum InjectorUtil {


    INSTANCE;

    App app;

    private InjectorUtil(){
    }

   public void initialize(App ap) {
        this.app = ap;

    }

    public   void Inject(Handlers handlers) {
        this.app.getHouseForRentComponent().inject(handlers);
    }
    public App getApp(){
        return app;
    }
}
