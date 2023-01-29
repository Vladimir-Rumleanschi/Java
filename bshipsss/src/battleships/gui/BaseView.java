package battleships.gui;

import battleships.MainApplication;

/**
 * The class provides a reference to the main.
 * @author Alaa
 */
public abstract class BaseView {

    private static MainApplication mainApp = null;

    /**
     * Returns a reference.
     *
     * @return reference to the main application
     */
    public static MainApplication getMainApp() {
        if (mainApp == null) {
            try {
                throw new Exception("No reference to mainApp.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mainApp;
    }

    public static void setMainApp(MainApplication mainApp) {
        BaseView.mainApp = mainApp;
    }

}
