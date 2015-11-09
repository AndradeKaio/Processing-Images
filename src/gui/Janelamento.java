package gui;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Janelamento extends Application 
{
	
	private static Slider sliderContrast;
	private static Slider sliderGrayScale;
	private static Scene scene;
	private static ImageView imageView;
	

	public void start(Stage primaryStage) throws Exception 
	{
		BorderPane root     = new BorderPane();
		BorderPane bpConfig = new BorderPane();
		VBox       vbox     = new VBox();
		Pane paneImage      = new Pane();
		imageView		    = new ImageView();
		//Configure Sliders
		configSliders();
		
		/* Pane Top */
		imageView.autosize();
		imageView.preserveRatioProperty().set(true);
	    paneImage.setPrefSize(380, 280);
	    paneImage.getChildren().add(imageView);
	    
	    /* HBOX */
	    vbox.getChildren().addAll(sliderGrayScale,sliderContrast);
	    
	    /* BorderPane Bot */
	    bpConfig.setPrefSize(380, 150);
	    bpConfig.setPadding(new Insets(10));
	    bpConfig.setLeft(vbox);

	   

	    
		root.setTop(paneImage);
		root.setBottom(bpConfig);

		scene  = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void configSliders()
	{
		sliderGrayScale = new Slider(0, 256, 0);
		sliderContrast  = new Slider(0, 256, 0);


		sliderGrayScale.setMajorTickUnit(64.0);
		sliderContrast.setMajorTickUnit(64.0);
		
		sliderGrayScale.setBlockIncrement(1);
		sliderContrast.setBlockIncrement(1);

		sliderGrayScale.setShowTickMarks(true);
		sliderContrast.setShowTickMarks(true);
		
		sliderGrayScale.setShowTickLabels(true);
		sliderContrast.setShowTickLabels(true);
	}
	
	public static int getSliderValue()
	{
		return (int)sliderGrayScale.getValue();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

}
