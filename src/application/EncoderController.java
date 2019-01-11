package application;

import java.net.URL;
import java.util.ResourceBundle;

import encoder.TextEncoder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EncoderController implements Initializable {
	@FXML
	TextField encodeTextField;
	
	@FXML
	private ComboBox<String> comboBox;
	
	private TextEncoder textEncoder;
	
	public void setTextEncoder(TextEncoder textEncoder)
	{
		this.textEncoder = textEncoder;
	}
	@FXML
	protected void handleDecodeButton(ActionEvent event)
	{
		String text = encodeTextField.getText();
		String result = textEncoder.decode(text);
		encodeTextField.setText(result);
	}
	@FXML
	protected void handleEncodeButton(ActionEvent event)
	{
		String text = encodeTextField.getText();
		String result = textEncoder.encode(text);
		encodeTextField.setText(result);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String firstOption = " CesarEncoder ";
		String secondOption = " AlfabetEncoder ";
		comboBox.getItems().add(firstOption);
		comboBox.getItems().add(secondOption);
	}
}

