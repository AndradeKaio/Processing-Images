package gui;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import processing.ImageManager;

public class Janelamento extends Application 
{
	
	private static Slider sliderContrast;
	private static Slider sliderGrayScale;
	private static Scene scene;
	private static ImageView imageView;
	private static ImagePane imagePane;
	

	public void start(Stage primaryStage) throws Exception 
	{

		Label grayScaleTitle = new Label();
		Label contrastTitle  = new Label();
		VBox       vbox      = new VBox();
		BorderPane root      = new BorderPane();
		BorderPane bpConfig  = new BorderPane();
		
		
		imagePane 			= new ImagePane();
		imageView		    = new ImageView();
		
		
		//Configure Sliders
		configSliders();
		
		/* imageView Top */
		//imageView.autosize();
		//imageView.preserveRatioProperty().set(true);
	    //imageView.setImage(imageFromSelection());
	    
	    /* VBOX Labels*/
		grayScaleTitle.setText("Gray Scale");
		contrastTitle.setText("Contrast");
	    vbox.getChildren().addAll(grayScaleTitle, sliderGrayScale, contrastTitle, sliderContrast);
	    
	    /* BorderPane Bot */
	    bpConfig.setPrefSize(380, 150);
	    bpConfig.setPadding(new Insets(10));
	    bpConfig.setCenter(vbox);
	   
	    /* BorderPane Root*/
	    
		root.setCenter(imageView);
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
	
	public static int getGrayScaleSlider()
	{
		return (int)sliderGrayScale.getValue();
	}
	
	public static Image imageFromSelection()
	{
		Image image = null;
		if(imagePane.isSubImageReady())
		{
			image = ImageManager.mat2Image(imagePane.getSubImage());
		}
		else
		{
			System.out.println("Nenhuma imagem foi carregada!");
		}
		return image;
	}
	
	
	public static Image saveEdits()
	{
		return null;
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

}
