package controllers;

import play.libs.F;
import play.mvc.Controller;
import play.mvc.WebSocket;

public class WsJava extends Controller {
    
    public static WebSocket<String> echo() {
        return new WebSocket<String>() {
            @Override
            public void onReady(final In<String> in, final Out<String> out) {
                in.onMessage(new F.Callback<String>() {
                    @Override
                    public void invoke(String message) throws Throwable {
                        out.write(message);
                    }
                });
            }
        };
    }
    
}
