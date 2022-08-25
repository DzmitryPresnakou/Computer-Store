package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.log4j.Logger;
import model.Device;

public class MyListSelectionListener extends BaseController implements ListSelectionListener {

	private final static Logger LOGGER = Logger.getLogger(MyListSelectionListener.class);

	@Override
	public void valueChanged(ListSelectionEvent e) {
		LOGGER.info("MyListSelectionListener called");
		int index = listWindow.getMyList().getSelectedIndex();
		if (index >= 0) {
			String type = listWindow.getFrame().getTitle();

			List<Device> newDatabase = database.searchDeviceByType(type);

			String name = newDatabase.get(index).getName();
			int price = newDatabase.get(index).getPrice();

			listWindow.setDeviceNameField(name);
			listWindow.setDevicePriceField(Integer.toString(price));

			LOGGER.debug("device - name " + name + ", price = " + price + " selected");

		} else {
			listWindow.setDeviceNameField(null);
			listWindow.setDevicePriceField(null);

			LOGGER.debug("nothing selected");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
