package controlevoo;

import org.junit.Assert;
import org.junit.Test;

import br.com.unicsul.planovoo.entity.Planetas;

public class ControleVooTest {

	@Test
	public void verificarOrigemDestino(){
		 Planetas origem = new Planetas();
		 Planetas destino = new Planetas();
		 
		 origem.setName("Marte");
		 destino.setName("Plutao");
		 
		 Assert.assertNotEquals(origem.getName(), destino.getName());
	}
}
