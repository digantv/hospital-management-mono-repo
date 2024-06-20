package case_edit;

import common.StageFactory;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class EditCaseScreen {
  public static void showCaseEditScreen() throws Exception {
    try {

      Parent actorGroup =
          FXMLLoader.load(
              new URL(
                  "file:///C:\\\\SGTek\\\\/hospital-console-fxml/src/main/java/case_edit/CaseEdit.fxml"));
      StageFactory.stage.setTitle("Customer Login");
      Scene scene = new Scene(actorGroup, 1270, 750);
      StageFactory.stage.setScene(scene);
      StageFactory.stage.setFullScreen(false);
      StageFactory.stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
