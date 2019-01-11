package application;

import encoder.TextEncoder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EncoderController {
	@FXML
	TextField encodeTextField;
	
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
}

