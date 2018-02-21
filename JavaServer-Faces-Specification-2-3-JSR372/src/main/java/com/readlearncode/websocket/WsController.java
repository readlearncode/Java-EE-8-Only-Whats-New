package com.readlearncode.websocket;

import javax.enterprise.context.SessionScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class WsController implements Serializable {

    @Inject
    @Push
    private PushContext pushContext;

    private String handle;
    private String message;

    public void sendMessage() {
        pushContext.send(handle + " says " + message);
    }

    public String navigateToChat() {
        return "chat";
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
