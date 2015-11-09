package gui;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import processing.Classify;
import processing.Timer;

public class Results extends Application
{
	private long timeResults;
	private int WIDHT = 525;
	private int HEIGHT = 580;
	
	private MessagePane messagePane;
	
	private Stage stage;
	private Pane paneGraph;
	private Scene scene;
	private BorderPane root;
	private TextArea taResults;
	private PlotGraphs plot;
	private ArrayList<Double> accumulator;


	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		stage         = primaryStage;
		root          = new BorderPane();
		messagePane   = new MessagePane();
		plot 		  = new PlotGraphs();
		accumulator   = new ArrayList<>();

		
		root.setTop(thisTextArea());
		root.setCenter(thisPaneCenter());
		
		
		scene = new Scene(root, WIDHT, HEIGHT);
		stage.setTitle("Results of classification");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();	
	}
	
	/**
	 * Obter o grafico da classe
	 * PlotGraph
	 * @return
	 */
	public Pane getGraph()
	{
		Pane p = null;
	    double [] a = {1,2,3,4,1,1,3,4,4,0};
		plot.receiveData(dataToPlot(a));
		p =  plot.plot();
		return p;
	}
	/**
	 * Adicionar informacoes no campo de texto
	 */
	public void getInformations()
	{
		taResults.setText(Timer.result());
	}
	
	public TextArea thisTextArea()
	{
		taResults   = new TextArea("TESTE");
		taResults.setEditable(false);
		taResults.setFocusTraversable(false);
		return taResults;
	}
	
	public Pane thisPaneCenter()
	{
	    paneGraph  = new Pane();
		paneGraph.getChildren().add(getGraph());
		return paneGraph;
	}
	
	
	public ArrayList<Double> dataToPlot(double [] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			accumulator.add(array[i]);
		}
		return accumulator;
	}
	
	

}
