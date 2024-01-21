import org.junit.jupiter.api.Assertions;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class HIghContrastThemeTest {

    public void testHighContrastTheme() {
        HIghContrastTheme hIghContrastTheme = new HIghContrastTheme();
        Assertions.assertEquals(Color.DARK_GRAY, hIghContrastTheme.getHighContrastButton());
        Assertions.assertEquals(Color.LIGHT_GRAY, hIghContrastTheme.getHighContrastBackground());
    }

}