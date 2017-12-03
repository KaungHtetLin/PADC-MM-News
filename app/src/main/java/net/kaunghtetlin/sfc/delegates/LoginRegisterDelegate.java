package net.kaunghtetlin.sfc.delegates;

/**
 * Created by Kaung Htet Lin on 11/26/2017.
 */

public interface LoginRegisterDelegate {
    void onTapLogin();
    void onTapForgetPassword();
    void onTapToRegister();

    void setScreenTitle(String name);
}
