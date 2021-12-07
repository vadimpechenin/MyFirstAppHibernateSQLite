package animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

// Класс для создания анимации при неправильно введенных данных
public class Shake {
    private TranslateTransition tt;
    // Node - любой объект в окне
    public Shake(Node node) {
        tt = new  TranslateTransition(Duration.millis(70), node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(3);
        // поле возвращается обратно
        tt.setAutoReverse(true);
    }
    // Метод для проигрывания анимации
    public void playAnim(){
        tt.playFromStart();
    }

}
