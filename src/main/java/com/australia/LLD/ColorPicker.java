package com.australia.LLD;

import java.util.*;

class Color {
    private String hexCode;

    public Color(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }
}

class ColorList {
    private List<Color> colors;
    private String owner;

    public ColorList(String owner) {
        this.colors = new ArrayList<>();
        this.owner = owner;
    }

    public void addColor(Color color) {
        colors.add(color);
    }

    public void removeColor(Color color) {
        colors.remove(color);
    }

    public List<Color> getColors() {
        return colors;
    }

    public String getOwner() {
        return owner;
    }
}

class User {
    private String email;
    private ColorList colorList;

    public User(String email) {
        this.email = email;
        this.colorList = new ColorList(email);
    }

    public void addColor(Color color) {
        colorList.addColor(color);
    }

    public void removeColor(Color color) {
        colorList.removeColor(color);
    }

    public ColorList getColorList() {
        return colorList;
    }

    public String getEmail() {
        return email;
    }
}

public class ColorPicker {
    private Map<String, User> users;

    public ColorPicker() {
        this.users = new HashMap<>();
    }

    public void registerUser(String email) {
        users.put(email, new User(email));
    }

    public void addColor(String email, Color color) {
        User user = users.get(email);
        if (user != null) {
            user.addColor(color);
        }
    }

    public void removeColor(String email, Color color) {
        User user = users.get(email);
        if (user != null) {
            user.removeColor(color);
        }
    }

    public void shareColorList(String email, List<String> recipients) {
        User user = users.get(email);
        if (user != null) {
            ColorList colorList = user.getColorList();
            // Send color list to recipients via email
            System.out.println("Sharing color list with " + recipients);
        }
    }

    public static void main(String[] args) {
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.registerUser("user1@example.com");
        colorPicker.addColor("user1@example.com", new Color("#FF0000"));
        colorPicker.addColor("user1@example.com", new Color("#00FF00"));
        colorPicker.shareColorList("user1@example.com", Arrays.asList("user2@example.com", "user3@example.com"));
    }
}
