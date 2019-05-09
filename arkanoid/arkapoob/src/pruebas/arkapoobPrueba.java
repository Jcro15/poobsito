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
		Arkapoob arka = new Arkapoob(1,600,600);
		//System.out.println("aaa"+arka.getJugador(0).getPlatform().getX());
		assertTrue(arka.getJugador(0).getPlatform().getX()==202.0);
		arka.moverPlataformaDerecha(0);
		
		assertTrue(arka.getJugador(0).getPlatform().getX()==202.6);
	}
	
	@Test
	public void deberiaMoverPlataformaIzquierda(){
		Arkapoob arka = new Arkapoob(1,600,600);
		assertTrue(arka.getJugador(0).getPlatform().getX()==202.0);
		arka.moverPlataformaIzquierda(0);
		assertTrue(arka.getJugador(0).getPlatform().getX()==201.4);
	}
	
	@Test
	public void noDeberiaSalirseIzquierda(){
		Arkapoob arka = new Arkapoob(1,600,600);
		assertTrue(arka.getJugador(0).getPlatform().getX()==202.0);
		for(int i=0; i<341; i++){
			arka.moverPlataformaIzquierda(0);
		}
		
		assertTrue(arka.getJugador(0).getPlatform().getX()==0.4000000000012004);
	}
	
	@Test
	public void noDeberiaSalirseDerecha(){
		Arkapoob arka = new Arkapoob(1,600,600);
		assertTrue(arka.getJugador(0).getPlatform().getX()==202);
		for(int i=0; i<700; i++){
			arka.moverPlataformaDerecha(0);
		}
		
		assertTrue(arka.getJugador(0).getPlatform().getX()+arka.getJugador(0).getPlatform().getWidth()==599.8000000000079);
	}
	
	@Test
	public void deberiaCogerPoderMasTamano(){
		Arkapoob arka = new Arkapoob(1,485,665);
		Poder poder = new PoderAumentarTamano(arka,205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getJugador(0).getPlatform().getWidth()==160);
	}
	@Test
	public void deberiaCogerPoderMenosTamano(){
		Arkapoob arka = new Arkapoob(1,485,6650);
		Poder poder = new PoderDisminuirTamano(arka,205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getJugador(0).getPlatform().getWidth()==80);
	}
	
	@Test
	public void deberiaCogerPoderMasVelocidad(){
		Arkapoob arka = new Arkapoob(1,485,665);
		Poder poder = new PoderAumentoVelocidad(arka,205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		
		assertTrue(arka.getBola().getVelocity()==0.9);
	}
	
	@Test
	public void deberiaCogerPoderMenosVelocidad(){
		Arkapoob arka = new Arkapoob(1,485,665);
		Poder poder = new PoderDisminuirVelocidad(arka,205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getBola().getVelocity()==0.7000000000000001);
	}
	
	@Test
	public void deberiaCogerPoderCambioEspecial(){
		Arkapoob arka = new Arkapoob(1,485,665);
		Poder poder = new PoderCambioEspecial(arka,205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getJugador(0).getPlatform().getClass().getSimpleName().equals("PlataformaEspecial"));
	}
	
	@Test
	public void deberiaCogerPoderCambioPegajosa(){
		Arkapoob arka = new Arkapoob(1,485,665);
		Poder poder = new PoderCambioPegajosa(arka,205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getJugador(0).getPlatform().getClass().getSimpleName().equals("PlataformaPegajosa"));
	}
	
	@Test
	public void deberiaCogerPoderCambioEspecialYMoverse(){
		Arkapoob arka = new Arkapoob(1,485,665);
		Poder poder = new PoderCambioEspecial(arka,205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getJugador(0).getPlatform().getClass().getSimpleName().equals("PlataformaEspecial"));
		arka.moverPlataformaIzquierda(0);
		assertTrue(arka.getJugador(0).getPlatform().getX()==202.6);
		
	}
	
	
	@Test
	public void deberiaSerPegajosaYMoverse(){
		Arkapoob arka = new Arkapoob(1,485,665);
		Plataforma p=arka.getJugador(0).getPlatform();
		Bola bola = new Bola(205,621,arka);
		arka.getJugador(0).setPlataforma(new PlataformaPegajosa(p.getX(),p.getY(), arka,p.getHeight(),p.getWidth()));
		bola.reactToCollision(p);
		arka.moverPlataformaDerecha(0);
		assertTrue(arka.getJugador(0).getPlatform().getX()==202.6);
		
	}
	
	
	@Test
	public void deberiaChocarConIndestructible(){
		Arkapoob arka = new Arkapoob(1,485,665);
		arka.anadirBloque(new BloqueIndestructible(arka,315,250));
		ArrayList<Bloque> bloques = arka.getBloques();
		int len= bloques.size();
		
		for(int i=0;i<479;i++){
			
			arka.moverElementos();
		}
		ArrayList<Bloque> bloques1 = arka.getBloques();
		
		assertTrue(len-bloques1.size()==0);
	}
	
	@Test
	public void deberiaChocarConResistente(){
		Arkapoob arka = new Arkapoob(1,485,665);
		arka.anadirBloque(new BloqueResistente(arka,315,250));
		ArrayList<Bloque> bloques = arka.getBloques();
		int len= bloques.size();
		
		for(int i=0;i<479;i++){
			
			arka.moverElementos();
		}
		ArrayList<Bloque> bloques1 = arka.getBloques();
		
		assertTrue(len-bloques1.size()==0);
	}
	
	@Test
	public void deberiaObtenerVida(){
		Arkapoob arka = new Arkapoob(1,485,665);
		arka.anadirBloque(new BloqueVida(arka,315,250));
		
		
		for(int i=0;i<479;i++){
			
			arka.moverElementos();
		}
		
		
		assertTrue(arka.getJugador(0).getLives()==4);
	}
	
	@Test
	public void deberiaChocarConSorpresa(){
		Arkapoob arka = new Arkapoob(1,485,665);
		arka.anadirBloque(new BloqueSorpresa(arka,315,250));
		for(int i=0;i<479;i++){
			
			arka.moverElementos();
		}
		ArrayList<Poder> poderes = arka.getPoderes();
		
		assertTrue(poderes.size()==1);
	}
}
	
	
	
