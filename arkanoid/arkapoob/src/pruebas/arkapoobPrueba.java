package pruebas;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import aplicacion.*;
import java.util.ArrayList;

/**
 * The test class arkapoobPrueba.
 *
 * @author  (Juan Camilo Angel)
 * @version (a version number or a date)
 */
public class arkapoobPrueba
{
    /**
     * Default constructor for test class gtfh
     */
    public arkapoobPrueba()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @Test
    public void deberiaMoverPlataformaDerecha()
    {
		Arkapoob arka = new Arkapoob(600,600);
		assertTrue(arka.getJugador().getPlatform().getX()==202);
		arka.moverPlataformaDerecha();
		assertTrue(arka.getJugador().getPlatform().getX()==203);
	}
	
	@Test
	public void deberiaMoverPlataformaIzquierda(){
		Arkapoob arka = new Arkapoob(600,600);
		assertTrue(arka.getJugador().getPlatform().getX()==202);
		arka.moverPlataformaIzquierda();
		assertTrue(arka.getJugador().getPlatform().getX()==201);
	}
	
	@Test
	public void noDeberiaSalirseIzquierda(){
		Arkapoob arka = new Arkapoob(600,600);
		assertTrue(arka.getJugador().getPlatform().getX()==202);
		for(int i=0; i<250; i++){
			arka.moverPlataformaIzquierda();
		}
		assertTrue(arka.getJugador().getPlatform().getX()==0);
	}
	
	@Test
	public void noDeberiaSalirseDerecha(){
		Arkapoob arka = new Arkapoob(600,600);
		assertTrue(arka.getJugador().getPlatform().getX()==202);
		for(int i=0; i<700; i++){
			arka.moverPlataformaDerecha();
		}
		assertTrue(arka.getJugador().getPlatform().getX()+arka.getJugador().getPlatform().getWidth()==600);
	}
	
	@Test
	public void deberiaChocarConBloque(){
		Arkapoob arka = new Arkapoob(485,665);
		ArrayList<Bloque> bloques = arka.getBloques();
		int len= bloques.size();
		for(int i=0; i<500; i++){
			arka.moverBola();
		}
		ArrayList<Bloque> bloques1 = arka.getBloques();
		assertTrue(arka.getJugador().getScore()==100);
		assertTrue(len-bloques1.size()==1);
		assertTrue(arka.getBola().getDy()==1);
	}
	
	@Test
	public void deberiaPerderVida(){
		Arkapoob arka = new Arkapoob(485,665);
		for(int i=0; i<13703; i++){
			arka.moverBola();
		}
		assertTrue(arka.isGameOver());
	}
}
	
	
	
