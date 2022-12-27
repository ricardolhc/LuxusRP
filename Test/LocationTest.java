package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocationTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testHashCode() {
		int y = 10;
		
		Location l = new Location(0,1);
		
		//65536 é o tamanho maximo de 16 bits, o hashCode retorna um espaço correspondente para y do tamanho de 16bits com a posição de x
		
		assertTrue(l.hashCode() >= 65536);
		
	}

	@Test
	void testLocation() {
		 int xInicial = 10, yInicial = 10;
	        Location iniciaLocation = new Location(xInicial, yInicial);
	        
	        //Testa a distancia imediata para cada direção de xInicial e yInicial 
	        int[][] distancias = {
	            { 0, 1, 0, 1, -1, 0, -1, 1, -1},
	            { 0, 0, 1, 1, 0, -1, -1, -1, 1},
	        };

	        for(int i = 0; i < distancias[0].length; i++) {
	            Location destination = new Location(xInicial + distancias[0][i],
	                                       yInicial + distancias[1][i]);
	            Location nextLocation = iniciaLocation.nextLocation(destination);
	            assertEquals(nextLocation.equals(destination), true);
	        }
	    
	}

	@Test
	void testNextLocation() {
		int xInicial = 10, yInicial = 10;
        Location iniciaLocation = new Location(xInicial, yInicial);
        // A distancia para cada direção de x e y inicial
        int[][] distancias = {
            { 0, 1, 0, 1, -1, 0, -1, 1, -1},
            { 0, 0, 1, 1, 0, -1, -1, -1, 1},
        };
        // Testa os destinos mais adjacentes
        //Usando valores diferentes de xDist e yDist conseguimos valores mais variados
        int xDist = 7;
        int yDist = 3;
        for(int i = 0; i < distancias[0].length; i++) {
            Location destination = new Location(xInicial + xDist * distancias[0][i],
                                       yInicial + yDist * distancias[1][i]);
            Location expectedNextLocation =
                        new Location(xInicial + distancias[0][i],
                                     yInicial + distancias[1][i]);
            Location nextLocation = iniciaLocation.nextLocation(destination);            
            assertEquals(expectedNextLocation.equals(nextLocation), true);
        }
    
		
	}

	@Test
	void testDistance() {
		 	boolean ok = true;
	        int xInicial = 10, yInicial = 10;
	        Location iniciaLocation = new Location(xInicial, yInicial);
	        
	        // Calcule a distância do inicio da localização até o seu destino 
	        // A distancia percorrida deve ser sempre igual a distância incial ao destino 
	        
	        int distancia = 5;
	        assertEquals(iniciaLocation.distance(
	            new Location(xInicial, yInicial + distancia)), distancia);
	        assertEquals(iniciaLocation.distance(
	            new Location(xInicial + distancia, yInicial)), distancia);
	        assertEquals(iniciaLocation.distance(
	            new Location(xInicial + 1, yInicial + distancia)), distancia);
	        assertEquals(iniciaLocation.distance(
	            new Location(xInicial + distancia, yInicial + 1)), distancia);
	        assertEquals(iniciaLocation.distance(
	            new Location(xInicial + distancia, yInicial + distancia)), distancia);
	        assertEquals(iniciaLocation.distance(
	            new Location(xInicial + distancia - 1, yInicial + distancia)), distancia);
	        assertEquals(iniciaLocation.distance(
	            new Location(xInicial + distancia, yInicial + distancia - 1)), distancia);
	        
	
	}

	@Test
	void testEqualsObject() {
		
	}

	@Test
	void testToString() {
		
	}

	@Test
	void testGetX() {
		
		//Verifica se o valor que retorna x não é nulo
		
		Location x = new Location( 1, 0);
		
		x.nextLocation(new Location(1,2));
		
		assertNotNull(x.nextLocation(x));

		int x1 = 10;
		Location l = new Location(x1, 30);		
		assertEquals(l.getX(),x1);
		
	}

	@Test
	void testGetY() {
		
		//Verifica se o valor que retorna y não é nulo
		Location y = new Location( 1, 0);
		
		y.nextLocation(new Location(1,2));
		
		assertNotNull(y.nextLocation(y));

		int y1 = 10;
		Location l = new Location(15, y1);		
		assertEquals(l.getY(),y1);
		
	}

	@Test
	void testObject() {
		
	}

	@Test
	void testGetClass() {
		
	}

	@Test
	void testToString1() {
		
	}

}
