package gui;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

//You might need to do something to the following line
public class ItemPane extends GridPane {

	private ObservableList<ItemButton> itemButtonList = FXCollections.observableArrayList();

	public ItemPane() {
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);

		// initialize 6 item buttons
		final String[] names = { "Corn", "Coffee", "Blueberry", "Strawberry", "Pineapple", "DestroyTool" };
		for (int i = 0; i < names.length; i++) {
			ItemButton itemBtn = new ItemButton(names[i]);
			itemBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					if (SimulationManager.getMoney() >= itemBtn.getItem().getPrice())
						setSelectedButton(itemBtn);
				}

			});
			itemButtonList.add(itemBtn);
			this.setRowIndex(itemBtn, i % 2);
			this.setColumnIndex(itemBtn, i % 3);
			this.getChildren().add(itemBtn);
		}

	}

	public void setSelectedButton(ItemButton selecteditemButton) {
		SimulationManager.setSelectedItemButton(selecteditemButton);
		resetButtonsBackGroundColor();
		selecteditemButton.highlight();
	}

	public void resetButtonsBackGroundColor() {
		for (Iterator<ItemButton> iterator = itemButtonList.iterator(); iterator.hasNext();) {
			ItemButton itemButton = iterator.next();
			itemButton.unhighlight();
		}
	}

}
