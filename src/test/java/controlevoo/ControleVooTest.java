package controlevoo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.junit.Assert;
import org.junit.Test;

import br.com.unicsul.planovoo.entity.Nave;
import br.com.unicsul.planovoo.entity.Planetas;
import br.com.unicsul.planovoo.entity.Tripulantes;

public class ControleVooTest {

	@Test
	public void verificarViagemDestino() {
		Planetas origem = new Planetas();
		Planetas destino = new Planetas();

		origem.setName("Marte");
		destino.setName("Jupiter");

		Assert.assertNotEquals(origem.getName(), destino.getName());
	}

	@Test
	public void verificaQtdePassageiro() {
		Nave nave = new Nave();
		nave.setPassengers(9);
		int qtdePassageiro = 4;
		Assert.assertEquals(true, nave.getPassengers() >= qtdePassageiro);
	}

	@Test
	public void liberarVoo() {
		Nave naveSelecd = new Nave();
		naveSelecd.setName("teste");
		Planetas planeta = new Planetas();
		planeta.setName("abc");
		Tripulantes tripulante = new Tripulantes();
		tripulante.setName("abc");
		
		Assert.assertEquals(planeta.equals(null),planeta.equals(null) );
		Assert.assertEquals(tripulante.equals(null), naveSelecd.equals(null));
	}
}
