package br.com.unicsul.planovoo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.unicsul.planovoo.dao.impl.NaveDAOImpl;
import br.com.unicsul.planovoo.dao.impl.PlanetasDAOImpl;
import br.com.unicsul.planovoo.dao.impl.TripulantesDAOImpl;
import br.com.unicsul.planovoo.entity.Nave;
import br.com.unicsul.planovoo.entity.Planetas;
import br.com.unicsul.planovoo.entity.PlanoVoo;
import br.com.unicsul.planovoo.entity.Tripulantes;

@ManagedBean
@RequestScoped
public class ControleVoo {

	private List<Tripulantes> listarTripulantes;
	private List<Nave> listarNave;
	private List<Planetas> listarPlanetas;
	private NaveDAOImpl naveDao = new NaveDAOImpl();
	private PlanetasDAOImpl planetaDao = new PlanetasDAOImpl();
	private TripulantesDAOImpl tripulacaoDAO = new TripulantesDAOImpl();
	private List<Planetas> pesquisarPlaneta;
	private List<Nave> pesquisarNave;
	private List<Nave> pesquisarTripulante;
	private Planetas planetaSelected = new Planetas();
	private Nave naveSelected = new Nave();
	private List<Tripulantes> tripulanteSelected = new ArrayList<Tripulantes>();
	private boolean ativar = true;
	private List<PlanoVoo>listaPlanoVoo;
	
	FacesContext fc= FacesContext.getCurrentInstance();
	@PostConstruct
	public void init() {
		listarTripulantes = (List<Tripulantes>) tripulacaoDAO.listarTripulantes();
		listarPlanetas = (List<Planetas>) planetaDao.listarDadosPlanetas();
		listarNave = (List<Nave>) naveDao.listarNaves();
		System.out.println("ok");
		}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Tripulante Selecionado", ((Tripulantes) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowNaveSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Nave Selecionado", ((Nave) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowPlanetasSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Nave Selecionado", ((Planetas) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	public boolean checarViagemAnterior(Planetas planeta){
		boolean qtdePassageiro = checarQtdePassageiro(this.naveSelected,this.tripulanteSelected.size());
		if(planeta != null){
			String planetas =  (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("viagemAnterior") ;
			if(qtdePassageiro){
				
			if(planetas!=null  && planetas.equals(planeta.getName())){
				FacesMessage msg = new FacesMessage("Viagem ao planeta de destino não foi Autorizada ", (planeta.getName()));
				FacesContext.getCurrentInstance().addMessage(null, msg);
				
				return false;
			}else{
				fc.getCurrentInstance().getExternalContext().getSessionMap().put("viagemAnterior", planeta.getName());
				FacesMessage msg = new FacesMessage("Viagem ao planeta de destino Autorizada ", (planeta.getName()));
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return true;
			}
		 }else{
				FacesMessage msg = new FacesMessage("Qtde de passageiros ultrapassa limite da aeronave ", (naveSelected.getName()));
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return false;
		 }
		}else{
			if(qtdePassageiro){
			fc.getCurrentInstance().getExternalContext().getSessionMap().put("viagemAnterior", this.planetaSelected);
			FacesMessage msg = new FacesMessage("Viagem ao planeta de destino Autorizada ", (planeta.getName()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return true;
			}else{
				FacesMessage msg = new FacesMessage("Qtde de passageiros ultrapassa limite da aeronave ", (naveSelected.getName()));
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return false;

			}
		}
	}
	public List<Tripulantes> getListarTripulantes() {
		return listarTripulantes;
	}

	public void setListarTripulantes(List<Tripulantes> listarTripulantes) {
		this.listarTripulantes = listarTripulantes;
	}

	public List<Nave> getListarNave() {
		return listarNave;
	}

	public void setListarNave(List<Nave> listarNave) {
		this.listarNave = listarNave;
	}

	public List<Planetas> getListarPlanetas() {
		return listarPlanetas;
	}

	public void setListarPlanetas(List<Planetas> listarPlanetas) {
		this.listarPlanetas = listarPlanetas;
	}

	public List<Planetas> getPesquisarPlaneta() {
		return pesquisarPlaneta;
	}

	public void setPesquisarPlaneta(List<Planetas> pesquisarPlaneta) {
		this.pesquisarPlaneta = pesquisarPlaneta;
	}

	public List<Nave> getPesquisarNave() {
		return pesquisarNave;
	}

	public void setPesquisarNave(List<Nave> pesquisarNave) {
		this.pesquisarNave = pesquisarNave;
	}

	public List<Nave> getPesquisarTripulante() {
		return pesquisarTripulante;
	}

	public void setPesquisarTripulante(List<Nave> pesquisarTripulante) {
		this.pesquisarTripulante = pesquisarTripulante;
	}

	public Planetas getPlanetaSelected() {
		return planetaSelected;
	}

	public void setPlanetaSelected(Planetas planetaSelected) {
		this.planetaSelected = planetaSelected;
	}

	public Nave getNaveSelected() {
		return naveSelected;
	}

	public void setNaveSelected(Nave naveSelected) {
		this.naveSelected = naveSelected;
	}

	
	
	public List<Tripulantes> getTripulanteSelected() {
		return tripulanteSelected;
	}

	public void setTripulanteSelected(List<Tripulantes> tripulanteSelected) {
		this.tripulanteSelected = tripulanteSelected;
	}

	
	public List<PlanoVoo> getListaPlanoVoo() {
		List<PlanoVoo>lista = (List<PlanoVoo>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("listPlanoVoo");
			if(lista != null && lista.size() > 0){
				listaPlanoVoo = lista;
			}else{}
		return listaPlanoVoo;
	}

	public void setListaPlanoVoo(List<PlanoVoo> listaPlanoVoo) {
		this.listaPlanoVoo = listaPlanoVoo;
	}

	public void liberarVoo(){
		boolean planetaDestidoIgualAnterior = checarViagemAnterior(this.planetaSelected);
		
		if(planetaDestidoIgualAnterior){
			PlanoVoo plano = new PlanoVoo();
			plano.setNave(naveSelected);
			plano.setTripulantes(tripulanteSelected);
			plano.setPlanetas(planetaSelected);

			List<PlanoVoo>pll = (List<PlanoVoo>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("listPlanoVoo");
			
			if(this.listaPlanoVoo == null && pll == null){
				this.listaPlanoVoo = new ArrayList<PlanoVoo>();
				this.listaPlanoVoo.add(plano);
				fc.getCurrentInstance().getExternalContext().getSessionMap().put("listPlanoVoo", this.listaPlanoVoo);

			}else{
				pll.add(plano);
				fc.getCurrentInstance().getExternalContext().getSessionMap().put("listPlanoVoo", pll);
			}
		   System.out.println("ok");
		}
	}

	private boolean checarQtdePassageiro(Nave naveSelected2, int qtdeTripulante) {
		if(naveSelected2.getPassengers() < qtdeTripulante){
			return false;
		}else{
			return true;
		}
	}

	//falta calcular a quantidade de passageiros e a mesma nao pode ser superior a capacidade da nave,
	//tem que realizar   os teste unitarios e incluir no readme os comentarios para rodar a aplicacao.
	

	
}
