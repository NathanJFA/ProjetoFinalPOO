package br.ufpb.barbeariaKlstar.Horario;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ufpb.pacote.code.Horario.AgendaDeHorarios;

public class AgendaDeHorariosTest {
	
	AgendaDeHorarios agendar;
	
	 @BeforeEach
	    void setUp() {
	        agendar = new AgendaDeHorarios();
	    }
	 @Test
	 void TestAgendarHorario() {
		 
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR, 2021);
			c.set(Calendar.MONTH, 11);
			c.set(Calendar.DAY_OF_MONTH, 8);
			c.set(Calendar.HOUR, 14);
			
			assertTrue(agendar.addHorario(c, "083"));

			/*System.out.println("Data/Hora atual: "+c.getTime());
			System.out.println("Ano: "+c.get(Calendar.YEAR));
			System.out.println("Mês: "+c.get(Calendar.MONTH));
			System.out.println("Dia do Mês: "+c.get(Calendar.DAY_OF_MONTH));*/
	 }
}
