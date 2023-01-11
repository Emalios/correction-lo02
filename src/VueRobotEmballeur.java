import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class VueRobotEmballeur implements Observer {

    JTextField jTextField = new JTextField();

    @Override
    public void update(Observable o, Object arg) {
            RobotEmballeur robotEmballeur = (RobotEmballeur) o;
            int nbJouet = robotEmballeur.getJouet().getNbJouets();
            //afficher nbJouet
            jTextField.setText(String.valueOf(nbJouet));
    }
}
