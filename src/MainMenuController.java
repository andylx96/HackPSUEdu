

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainMenuController {

    MainMenuModel n_model;
    MainMenuFrame n_frame;
    MainMenuView main_view;
    LoginView log_view;
    
    
    public MainMenuController(MainMenuModel n_model, MainMenuFrame n_frame) throws Throwable {
        this.n_model = n_model;
        this.n_frame = n_frame;
        main_view = new MainMenuView();
//        log_view = new LoginView();
        loadAccounts();

        main_view.getContactsButton().addActionListener(new ContactsButtonListener());
        n_frame.getMain_panel().getLog_view().getLoginButton().addActionListener(new LoginButtonListener());
        main_view.getCalendarButton().addActionListener(new CalendarButtonListener());
    }

    class ContactsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            {

    
            }
        }

    }

    class CalendarButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            {

            }
        }

    }

    class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            {

                String username = n_frame.getMain_panel().getLog_view().getUsernameCombo().getSelectedItem().toString();
                String password = n_model.getAccounts().get(1).get(n_frame.getMain_panel().getLog_view().getUsernameCombo().getSelectedIndex()).toString();
                if (n_frame.getMain_panel().getLog_view().getUsernameCombo().getSelectedItem().equals(username) && n_frame.getMain_panel().getLog_view().getPassword().getText().equals(password)) {

                    n_frame.switchToMainView(main_view);

                } else {
                    n_frame.getMain_panel().getLog_view().getLoginStatus().setText("Error, Please Enter The Correct Information");
                }
            }
        }
    }

    public void loadAccounts() {

        String tempUsername, tempPassword, tempSource;

        n_model.getAccounts().get(0).clear();
        n_model.getAccounts().get(1).clear();
        try {
            FileReader fin = new FileReader("src/Login.txt");
            Scanner scan = new Scanner(fin);
            while (scan.hasNextLine()) {

                tempUsername = scan.nextLine();
                tempPassword = scan.nextLine();

                n_model.getAccounts().get(0).add(tempUsername);
                n_model.getAccounts().get(1).add(tempPassword);
                n_frame.getMain_panel().getLog_view().getUsernameCombo().addItem(tempUsername);
            }

            fin.close();
        } catch (FileNotFoundException ex) {
            System.out.println("InfoNotFound");
        } catch (IOException ex) {
            System.out.println("InfoNotFound");
        }

    }

    

}
