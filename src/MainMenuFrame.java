

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainMenuFrame extends JFrame {

    MainMenuModel model;
    MainMenuFrame n_frame;
    MainMenuView main_view;
    LoginView log_view;
    MainMenuPanel main_panel;

    MainMenuFrame(MainMenuModel model) {
        super("App");
        this.model = model;
        main_panel = new MainMenuPanel();

        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(main_panel);
    }

    public void switchToMainView(MainMenuView main_view) {
   main_panel.removeLogin();
   main_panel.removeMainMenu();
   main_panel.addMainMenu(main_view);
    }

    public MainMenuModel getModel() {
        return model;
    }

    public void setModel(MainMenuModel model) {
        this.model = model;
    }

    public MainMenuPanel getMain_panel() {
        return main_panel;
    }

    public void setMain_panel(MainMenuPanel main_panel) {
        this.main_panel = main_panel;
    }

   
}
