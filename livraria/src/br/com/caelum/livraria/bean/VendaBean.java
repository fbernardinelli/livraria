package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.caelum.livraria.modelo.Venda;

@Named
@ViewScoped
public class VendaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;


	private BarChartModel barModel;

	public BarChartModel getBarModel() {
		return barModel;
	}

	public List<Venda> getVendas() {
		List<Venda> vendas = this.em.createQuery("select v from Venda v", Venda.class).getResultList();
		
		return vendas;
	}

	public BarChartModel getVendasModel(){
        BarChartModel model = new BarChartModel();
        model.setAnimate(true);
        
        ChartSeries vendasChart = new ChartSeries();
        ChartSeries vendasChart2015 = new ChartSeries();
        vendasChart.setLabel("Vendas 2016");
        vendasChart.setLabel("Vendas 2015");
        
        List<Venda> vendas = getVendas();
        
        for (Venda venda : vendas) {
        	vendasChart.set(venda.getLivro().getTitulo(), venda.getQuantidade());			
		}
        
        model.addSeries(vendasChart);
        model.addSeries(vendasChart2015);
         
        return model;
	}

}
