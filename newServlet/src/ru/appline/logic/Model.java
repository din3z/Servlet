package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
    private static final Model instance = new Model();

    private final Map<Integer, User> model;

    public static Model getInstance(){
        return instance;
    }

    private Model(){
        model = new HashMap<>();

        model.put(1, new User("Seyda", "Khalitova", 1111));
        model.put(2, new User("anton", "oss", 11112));
        model.put(3, new User("Zoya", "andr", 11113));
    }
    public void add(User user, int id){
        model.put(id, user);
    }

    public Map<Integer, User> getFrontList(){
        return model;
    }
}
