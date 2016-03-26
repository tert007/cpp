package controller;

import com.sun.deploy.net.HttpRequest;

import java.util.List;

/**
 * Created by Alexander on 23.02.2016.
 */
public interface Command {
    String execute(HttpRequest request);
}
