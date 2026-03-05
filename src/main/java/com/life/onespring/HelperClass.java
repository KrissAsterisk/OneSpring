package com.life.onespring;

public final class HelperClass {
    private HelperClass(){}

    public static java.util.List<String> getPagesList() {
        return java.util.Arrays.asList(
                "Lobby",
                "Discord",
                "Game Review",
                "My Contact Info",
                "Discord Rules",
                "My YouTube",
                "Design Your Taco");
        //used to iterate through using thymeleaf and get every page from the main links
    }
}
