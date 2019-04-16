package presentacion;

import javax.swing.*;
import java.awt.*;

public class myButton  extends JButton {
	
	public myButton(Icon icono){
		super(icono);
	}
	
	public void setTransparent(){
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusable(false);
	}
	
	
	
}
