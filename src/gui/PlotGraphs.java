package gui;

import java.util.ArrayList;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.Pane;

public class PlotGraphs
{
	
	/* Variaveis que receberam os resultados das calssificacoes*/
	//private static XYChart.Series classeOne, classeTwo, classeThree, classeFour;
	static XYChart.Series classeOne;
	static XYChart.Series classeTwo;
	static XYChart.Series classeThree;
	static XYChart.Series classeFour;
	private static final NumberAxis xAxis = new NumberAxis(0, 10, 1);
	private static final NumberAxis yAxis = new NumberAxis(0, 10, 1);
	private static ScatterChart<Number, Number> sc      = new ScatterChart<Number, Number>(xAxis, yAxis);
	/* Limites para cada eixo */
	
	/* Scatterplot */
	//private static ScatterChart<Number, Number> sc = null;
		
	public PlotGraphs() 
	{
		classeOne   = new XYChart.Series();					
		classeTwo   = new XYChart.Series();
		classeThree = new XYChart.Series();
		classeFour  = new XYChart.Series();
	}	
	/*
	 * Recebe os resultados obtidos pela calssificacao
	 * e os adiciona nas series correspondentes.
	 */
	public static void receiveData(ArrayList<Double> classification)
	{		
		
		for (int i = 0; i < classification.size(); i++) 
		{
			if(classification.get(i) == 0){
				classeOne.getData().add(new XYChart.Data(classification.get(i), classification.get(i)));
			}
			else if(classification.get(i) == 1){
				classeTwo.getData().add(new XYChart.Data(classification.get(i), classification.get(i)));
			}
			else if(classification.get(i) == 2){
				classeThree.getData().add(new XYChart.Data(classification.get(i), classification.get(i)));
			}
			else if(classification.get(i) == 3){
				classeFour.getData().add(new XYChart.Data(classification.get(i), classification.get(i)));
			}
		}
	}

	public static Pane plot()
	{
		Pane p = new Pane();
		//xAxis.setLabel("XXXXXXXXXXXXXX");
		//yAxis.setLabel("YYYYYYYYYYYYYY");
		sc.setTitle("Results Classification");
		classeOne.setName("Classe 1");
		classeTwo.setName("Classe 2");
		classeThree.setName("Classe 3");
		classeFour.setName("Classe 4");
		sc.getData().addAll(classeOne, classeTwo, classeThree, classeFour);
		sc.setPrefSize(500, 400);
		p.getChildren().add(sc);
		return p;
	}

}
