package controller;

import java.util.List;

/**
 * Created by Alexander on 23.02.2016.
 */
public interface Command {
    Object execute(String[] params);
}
