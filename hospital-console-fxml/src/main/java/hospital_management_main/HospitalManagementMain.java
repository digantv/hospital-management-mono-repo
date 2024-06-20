package hospital_management_main;

import common.StageFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import login_screen.LoginScreen;

public class HospitalManagementMain extends Application {
  public static void main(String args[]) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {

    StageFactory.stage = stage;
    try {
      LoginScreen.showLoginScreen();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
