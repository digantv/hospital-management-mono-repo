package patient_delete;

import appointment_page.AppointmentPageScreen;
import case_page.CasePageScreen;
import common.RestUtil;
import dashboard_page.DashboardScreen;
import dto.PatientResponse;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import login_screen.LoginScreen;
import patient_page.PatientScreen;
import user_page.UserScreen;

public class PatientDeleteScreenController implements Initializable {
  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;

  @FXML private Button cancle;

  @FXML private Button delete;

  @FXML private Button dashboard;

  @FXML private TextField patient_name_english;

  @FXML private TextField patient_name_marathi;

  @FXML private TextField mobile_number;

  @FXML private ComboBox<String> gender;

  @FXML private DatePicker birth_date;

  @FXML private DatePicker first_examination_date;

  @FXML private TextField address;

  @FXML private TextField patient_name_search;

  @FXML private TextField patient_id;

  @FXML private Button search;

  public void initialize(URL location, ResourceBundle resources) {

    ObservableList<String> lines = FXCollections.observableArrayList("Male", "Female");
    gender.setItems(lines);
  }

  public void PatientsButton(ActionEvent event) throws IOException {

    try {
      PatientScreen.showPatientScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void CasesButton(ActionEvent event) throws IOException {
    try {
      CasePageScreen.showCasePageScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void AppointmentButton(ActionEvent event) throws IOException {
    try {
      AppointmentPageScreen.showAppointmentPageScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void UsersButton(ActionEvent event) throws IOException {
    try {
      UserScreen.showUserScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void LogoutButton(ActionEvent event) throws IOException {

    try {
      LoginScreen.showLoginScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Search_Button(ActionEvent event) throws IOException {
    String patientId = patient_id.getText().trim();
    String patientNameEnglish = patient_name_search.getText().trim();

    PatientResponse response = null;

    try {
      if (!patientId.isEmpty()) {
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8082/api/v1/patient/" + patientId, PatientResponse.class);
      } else if (!patientNameEnglish.isEmpty()) {
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8082/api/v1/patient/name/" + patientNameEnglish,
                PatientResponse.class);
      }

      if (response != null && response.getStatus().equals("Success")) {
        patient_name_english.setText(response.getPatientNameEnglish());
        patient_name_marathi.setText(response.getPatient_name_marathi());
        mobile_number.setText(response.getMobile());
        gender.setValue(response.getGender());
        birth_date.setValue(LocalDate.parse(response.getBirth_date()));
        first_examination_date.setValue(LocalDate.parse(response.getFirst_examination_date()));
        address.setText(response.getAddress());
        setFieldsEditable(false);
      } else {
        showAlert("Error", "Patient not found", "Please enter a valid patient ID or Name.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      showAlert(
          "Error",
          "Failed to fetch patient details",
          "An error occurred while fetching the patient details.");
    }
  }

  public void Delete_Button(ActionEvent event) throws IOException {
    String patientId = patient_id.getText().trim();

    if (patientId.isEmpty()) {
      showAlert("Error", "Patient ID Required", "Please enter a patient ID to delete.");
      return;
    }

    try {
      PatientResponse response =
          RestUtil.sendDeleteRequest(
              "http://localhost:8082/api/v1/patient/" + patientId, PatientResponse.class);

      if (response != null && response.getStatus().equals("Success")) {
        showAlert("Success", "Patient deleted", "Patient has been deleted successfully.");
        patient_id.clear();
        patient_name_search.clear();
        patient_name_english.clear();
        patient_name_marathi.clear();
        mobile_number.clear();
        gender.setValue(null);
        birth_date.setValue(null);
        first_examination_date.setValue(null);
        address.clear();
      } else {
        showAlert(
            "Error", "Failed to delete patient", "An error occurred while deleting the patient.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      showAlert(
          "Error", "Failed to delete patient", "An error occurred while deleting the patient.");
    }
  }

  public void Cancle_Button(ActionEvent event) {
    try {
      DashboardScreen.showDashboardScreen();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void Dashboard(ActionEvent event) throws IOException {
    try {
      DashboardScreen.showDashboardScreen();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void showAlert(String title, String header, String content) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(header);
    alert.setContentText(content);
    alert.show();
  }

  private void setFieldsEditable(boolean editable) {
    patient_name_english.setEditable(editable);
    patient_name_marathi.setEditable(editable);
    mobile_number.setEditable(editable);
    gender.setDisable(!editable);
    birth_date.setEditable(editable);
    first_examination_date.setEditable(editable);
    address.setEditable(editable);
  }
}
