package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

//You might need to do something to the following line
public class FieldPane extends GridPane {

	private ObservableList<FieldCell> fieldCells = FXCollections.observableArrayList();

	public FieldPane() {
		this.setPrefWidth(500);
		this.setAlignment(Pos.CENTER);
		this.setVgap(8);
		this.setHgap(8);
		this.setPadding(new Insets(8));
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

		// populate fieldCells with 6 * 8 FieldCell(s)
		final int rows = 6;
		final int cols = 8;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				FieldCell fieldCell = new FieldCell();
				this.fieldCells.add(fieldCell);
				this.setRowIndex(fieldCell, row);
				this.setColumnIndex(fieldCell, col);
				this.getChildren().add(fieldCell);
			}
		}

	}

	public int calculateIncome() {
		int totalIncome = 0;
		for (FieldCell fieldCell : fieldCells) {
			Item crop = fieldCell.getCrop();
			if (crop != null) {
				totalIncome += crop.getIncome();
			}
		}

		return totalIncome;
	}

}
