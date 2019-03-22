package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import encoder.CesarTextEncoder;
import encoder.NewEncoder;
import encoder.TextEncoder;
import exception.ChooseOptionException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class EncoderController implements Initializable {
	private final static String FIRST_OPTION = " CesarEncoder ";
	private final static String SECOND_OPTION = " AlfabetEncoder ";
	private final static int CESAR_KEY = 3;
	private final static String fileSuffix = "_Zaszyfrowane";
	@FXML
	private TextField encodeTextField;
	
	@FXML
	private CheckBox modeCheckBox;
	
	@FXML
	private TextField pathTextField;
	
	@FXML
	private Button fileChooseButton;
	
	private FileChooser fileChooser = new FileChooser();
	
	@FXML
	private ComboBox<String> comboBox;
	
	@FXML
	private Button decodeButton;
	
	@FXML
	private Button encodeButton;
	
	private TextEncoder textEncoder;
	
	private String fileName;
	public void setTextEncoder(TextEncoder textEncoder)
	{
		this.textEncoder = textEncoder;
	}
	
	@FXML
	protected void handleFileChooseButton (ActionEvent event) 
	{
		try {
			initializeEncoder(comboBox.getValue());
		} catch (ChooseOptionException e1) {
			Alert alert = new Alert(AlertType.ERROR, "Zaznacz!", ButtonType.OK);
			e1.printStackTrace();
		}
		Node source = (Node) event.getSource();
		Window stage = source.getScene().getWindow();
		
		File chooseFile = fileChooser.showOpenDialog(stage);
		
		if(chooseFile == null) {
			return;
		}
		else{
			pathTextField.setText(chooseFile.getAbsolutePath());
			fileName = chooseFile.getAbsolutePath();
			
			fileChooser.setInitialDirectory(chooseFile.getParentFile());
			
			try {
				String tmp = read(chooseFile.getAbsolutePath());
				Writing(textEncoder.encode(tmp) , fileName , "szyfr");
			} catch (IOException e) {
				Alert alert = new Alert(AlertType.ERROR, "Plik Pusty!!", ButtonType.OK);
				e.printStackTrace();
			}
			
			try {
				String tmp1 = read(chooseFile.getAbsolutePath());
				Writing(textEncoder.decode(tmp1) , fileName , "odszyfr");
			} catch (IOException e) {
				Alert alert = new Alert(AlertType.ERROR, "Plik Pusty!!", ButtonType.OK);
				e.printStackTrace();
			}
		}
		/*try {
			initializeEncoder(comboBox.getValue());
			String text = read("plik.txt");
			String result = textEncoder.encode(text);
			Writing(result);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, "Wybierz rodzaj szyfrowania!", ButtonType.OK);
			alert.showAndWait();
		}*/
	}
	
	@FXML
	
	protected void handleFromFileCheckBox (ActionEvent event) 
	{
		boolean selected = modeCheckBox.isSelected();
		if(selected) 
		{
			decodeButton.setDisable(true);
			encodeButton.setDisable(true);
			encodeTextField.setDisable(true);
			fileChooseButton.setDisable(false);
			
		}
		else {
			decodeButton.setDisable(false);
			encodeButton.setDisable(false);
			encodeTextField.setDisable(false);
			fileChooseButton.setDisable(true);
		}
		
	}
	@FXML
	protected void handleDecodeButton(ActionEvent event)
	{
		
		try {
			initializeEncoder(comboBox.getValue());
			String text = encodeTextField.getText();
			String result = textEncoder.decode(text);
			encodeTextField.setText(result);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, "Wybierz rodzaj szyfrowania!", ButtonType.OK);
			alert.showAndWait();
		}
	}
	@FXML
	protected void handleEncodeButton(ActionEvent event)
	{	
		try {
			initializeEncoder(comboBox.getValue());
			String text = encodeTextField.getText();
			String result = textEncoder.encode(text);
			encodeTextField.setText(result);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, "Wybierz rodzaj szyfrowania!", ButtonType.OK);
			alert.showAndWait();
		}

	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBox.getItems().add(FIRST_OPTION);
		comboBox.getItems().add(SECOND_OPTION);
		pathTextField.setEditable(false);
	}
	
	private void initializeEncoder (String optionName) throws ChooseOptionException {
		
		if (optionName == null){
			throw new ChooseOptionException();
			//encodeTextField.setText("Wybierz Rodzaj Szyfrowania");
		}
		else if(optionName.equals(FIRST_OPTION)) {
			textEncoder = new CesarTextEncoder(CESAR_KEY);
			
		}
		else if(optionName.equals(SECOND_OPTION)){
			textEncoder = new NewEncoder();
		}

	}
	public String Reading() 
	{
		String tmp = "";
		try {
			tmp = read("plik.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tmp;
		
	}
	public void Writing(String result ,String Name , String Typ) 
	{
		try {
			if(Typ == "szyfr") 
			{
				write(Name+"_szyfr", result);
			}
			
			else
			{
				write(Name+"_odszyfr", result);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String read(String fileName) throws IOException {

		StringBuilder result = new StringBuilder();
		FileReader reader = new FileReader(fileName);
		BufferedReader bufferedreader = new BufferedReader(reader);
		String tmp;

		while ((tmp = bufferedreader.readLine()) != null) {
			result.append(tmp);
		}

		bufferedreader.close();
		return result.toString();

	}
	public void write(String fileName, String text) throws IOException {
		FileWriter writer = new FileWriter(fileName);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		bufferedWriter.write(text);
		bufferedWriter.close();

	}
	

}

