package login_screen;

import common.RestUtil;
import dashboard_page.DashboardScreen;
import dto.LoginRequest;
import dto.LoginResponse;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController {

  @FXML private TextField mobile_number;

  @FXML private PasswordField password;

  @FXML private Button next_button;

  public void Next_Button(ActionEvent event) throws SQLException {

    boolean loginStatus =
        LoginScreenController.ValidatemobileAndpassword(
            mobile_number.getText(), password.getText());

    if (loginStatus) {
      try {
        DashboardScreen.showDashboardScreen();
      } catch (Exception e) {

        e.printStackTrace();
      }
    } else {
      System.out.println("Login Unsuccessful");
    }
  }

  public static boolean ValidatemobileAndpassword(String mobile_number, String password)
      throws SQLException {

    LoginRequest loginRequest = new LoginRequest();

    loginRequest.setMobileNumber(mobile_number);
    loginRequest.setPassword(password);

    LoginResponse response;

    try {
      response =
          RestUtil.sendPostRequest(
              "http://localhost:8081/api/v1/directory/validate", LoginResponse.class, loginRequest);

      if (response.getStatus().equals("Success")) {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
}
