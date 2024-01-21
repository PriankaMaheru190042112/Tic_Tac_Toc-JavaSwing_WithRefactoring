import org.junit.jupiter.api.Assertions;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ForestThemeTest {
    public void testForestTheme(){
        ForestTheme forestTheme = new ForestTheme();

        Assertions.assertEquals(Color.green, forestTheme.getForestButton());
        Assertions.assertEquals(new Color(0,102,0), forestTheme.getForestBackground());
    }

}