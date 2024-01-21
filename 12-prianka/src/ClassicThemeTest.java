import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ClassicThemetest {

public void testClassicTheme(){
ClassicTheme classicTheme =new ClassicTheme();
 Assertions.assertEquals(Color.WHITE, classicTheme.getClassicButton());
 Assertions.assertEquals(Color.BLACK,classicTheme.getClassicBackground());
}
}