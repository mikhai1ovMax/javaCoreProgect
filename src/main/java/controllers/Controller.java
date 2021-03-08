package controllers;


import views.View;

public class Controller {

    private static Controller controller;
    private static int selectedAction;
    private static int selectedModel;

    private Controller() {
    }

    public static int getSelectedAction() {
        return selectedAction;
    }

    public static void setSelectedAction(int selectedAction) {
        Controller.selectedAction = selectedAction;
    }

    public static int getSelectedModel() {
        return selectedModel;
    }

    public static void setSelectedModel(int selectedModel) {
        Controller.selectedModel = selectedModel;
    }
}
