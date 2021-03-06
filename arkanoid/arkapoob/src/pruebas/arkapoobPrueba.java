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
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		//System.out.println("aaa"+arka.getJugador(0).getPlatform().getX());
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		assertTrue(arka.getJugador(0).getPlatform().getX()==202.0);
		arka.moverPlataformaDerecha(0);
		arka.getJugador(0).moverPlataforma();
		
		assertTrue(arka.getJugador(0).getPlatform().getX()==202.6);
	}
	
	@Test
	public void deberiaMoverPlataformaIzquierda(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		assertTrue(arka.getJugador(0).getPlatform().getX()==202.0);
		arka.moverPlataformaIzquierda(0);
		arka.getJugador(0).moverPlataforma();
		assertTrue(arka.getJugador(0).getPlatform().getX()==201.4);
	}
	
	@Test
	public void noDeberiaSalirseIzquierda(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		assertTrue(arka.getJugador(0).getPlatform().getX()==202.0);
		for(int i=0; i<341; i++){
			arka.moverPlataformaIzquierda(0);
			arka.getJugador(0).moverPlataforma();
		}
		
		assertTrue(arka.getJugador(0).getPlatform().getX()==0.4000000000012004);
	}
	
	@Test
	public void noDeberiaSalirseDerecha(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		assertTrue(arka.getJugador(0).getPlatform().getX()==202);
		for(int i=0; i<700; i++){
			arka.moverPlataformaDerecha(0);
			arka.getJugador(0).moverPlataforma();
		}
		
		assertTrue(arka.getJugador(0).getPlatform().getX()+arka.getJugador(0).getPlatform().getWidth()==484.6000000000036);
	}
	
	@Test
	public void deberiaCogerPoderMasTamano(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		arka.setBall();
		Poder poder = new PoderAumentarTamano(205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getJugador(0).getPlatform().getWidth()==160);
	}
	
	@Test
	public void deberiaCogerPoderMenosTamano(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		arka.setBall();
		Poder poder = new PoderDisminuirTamano(205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getJugador(0).getPlatform().getWidth()==80);
	}
	
	@Test
	public void deberiaCogerPoderMasVelocidad(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		arka.setBall();
		Poder poder = new PoderAumentoVelocidad(205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getBola().getVelocity()==0.9);
	}
	
	@Test
	public void deberiaCogerPoderMenosVelocidad(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		arka.setBall();
		Poder poder = new PoderDisminuirVelocidad(205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getBola().getVelocity()==0.7000000000000001);
	}
	
	@Test
	public void deberiaCogerPoderCambioEspecial(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		arka.setBall();
		Poder poder = new PoderCambioEspecial(205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getJugador(0).getPlatform().getClass().getSimpleName().equals("PlataformaEspecial"));
	}
	
	@Test
	public void deberiaCogerPoderCambioPegajosa(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		arka.setBall();
		Poder poder = new PoderCambioPegajosa(205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getJugador(0).getPlatform().getClass().getSimpleName().equals("PlataformaPegajosa"));
	}
	
	@Test
	public void deberiaCogerPoderCambioEspecialYMoverse(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		arka.setBall();
		Poder poder = new PoderCambioEspecial(205,620);
		arka.anadirPoder(poder);
		arka.moverElementos();
		assertTrue(arka.getJugador(0).getPlatform().getClass().getSimpleName().equals("PlataformaEspecial"));
		arka.moverPlataformaIzquierda(0);
		arka.getJugador(0).moverPlataforma();
		assertTrue(arka.getJugador(0).getPlatform().getX()==202.6);
		
	}
	
	
	
	
	@Test
	public void deberiaChocarConIndestructible(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		arka.setBall();
		arka.anadirBloque(new BloqueIndestructible(315,250));
		ArrayList<Bloque> bloques = arka.getBloques();
		int len= bloques.size();
		
		for(int i=0;i<479;i++){
			
			arka.moverElementos();
		}
		ArrayList<Bloque> bloques1 = arka.getBloques();
		assertFalse(bloques1.get(bloques1.size()-1).destroyed());
		assertTrue(arka.getJugador(0).getScore()==0);
		assertTrue(len-bloques1.size()==0);
	}
	
	@Test
	public void deberiaChocarConNormal(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		arka.setBall();
		arka.anadirBloque(new Bloque(315,250));
		ArrayList<Bloque> bloques = arka.getBloques();
		int len= bloques.size();
		
		for(int i=0;i<479;i++){
			
			arka.moverElementos();
		}
		ArrayList<Bloque> bloques1 = arka.getBloques();
		
		assertTrue(arka.getJugador(0).getScore()==100);
		assertTrue(len-bloques1.size()==1);
	}
	
	@Test
	public void deberiaChocarConResistente(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		arka.setBall();
		arka.anadirBloque(new BloqueResistente(315,250));
		ArrayList<Bloque> bloques = arka.getBloques();
		int len= bloques.size();
		
		for(int i=0;i<479;i++){
			
			arka.moverElementos();
		}
		ArrayList<Bloque> bloques1 = arka.getBloques();
		assertFalse(bloques1.get(bloques1.size()-1).destroyed());
		assertTrue(arka.getJugador(0).getScore()==0);
		assertTrue(len-bloques1.size()==0);
	}
	
	@Test
	public void deberiaObtenerVida(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		arka.setBall();
		arka.anadirBloque(new BloqueVida(315,250));
		ArrayList<Bloque> bloques = arka.getBloques();
		int len= bloques.size();
		for(int i=0;i<479;i++){
			
			arka.moverElementos();
		}
		ArrayList<Bloque> bloques1 = arka.getBloques();
		
		assertTrue(arka.getJugador(0).getScore()==300);
		assertTrue(len-bloques1.size()==1);
		assertTrue(arka.getJugador(0).getLives()==4);
	}
	
	@Test
	public void deberiaChocarConSorpresa(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(202,620);
		arka.anadirJugador(jugador);
		arka.setBall();
		arka.anadirBloque(new BloqueSorpresa(315,250));
		ArrayList<Bloque> bloques = arka.getBloques();
		int len= bloques.size();
		for(int i=0;i<479;i++){
			
			arka.moverElementos();
		}
		ArrayList<Poder> poderes = arka.getPoderes();
		ArrayList<Bloque> bloques1 = arka.getBloques();
		assertTrue(arka.getJugador(0).getScore()==300);
		assertTrue(len-bloques1.size()==1);
		assertTrue(poderes.size()==1);
	}
	
	@Test
	public void deberiaMoverseMimo(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(0,620);
		arka.anadirJugador(jugador);
		Jugador jugador1 = new CpuMimo(200,620);
		arka.anadirJugador(jugador1);
		arka.moverPlataformaDerecha(0);
		arka.getJugador(0).moverPlataforma();
		assertTrue(arka.getJugador(0).getPlatform().getX()==0.6);
		arka.getJugador(1).moverPlataforma();
		assertTrue(arka.getJugador(1).getPlatform().getX()==200.6);
	}
	
	@Test
	public void deberiaMoverseCurioso(){
		Arkapoob.nuevoTablero();
		Arkapoob arka = Arkapoob.demeTablero();
		Jugador jugador = new Jugador(0,620);
		arka.anadirJugador(jugador);
		Jugador jugador1 = new CpuCurioso(200,620);
		arka.anadirJugador(jugador1);
		arka.moverPlataformaDerecha(0);
		arka.getJugador(0).moverPlataforma();
		assertTrue(arka.getJugador(0).getPlatform().getX()==0.6);
		Poder poder = new PoderCambioEspecial(198,618);
		arka.anadirPoder(poder);
		arka.getJugador(1).moverPlataforma();
		assertTrue(arka.getJugador(1).getPlatform().getX()==199.4);
	}
	
}
	
	
	
