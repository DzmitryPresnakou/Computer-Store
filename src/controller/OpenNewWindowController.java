package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.List;

import org.apache.log4j.Logger;

import model.Device;
import view.DigitFilter;

public class OpenNewWindowController extends BaseController {
	private final static Logger LOGGER = Logger.getLogger(OpenNewWindowController.class);

	@Override
	public void actionPerformed(ActionEvent e) {
		String type = ((Component) e.getSource()).getName();
		listWindow.getFrame().setVisible(true);
		window.getFrame().setVisible(false);
		listWindow.getFrame().setTitle(type);
		listWindow.getPriceDoc().setDocumentFilter(null);
		List<Device> newDatabase = database.searchDeviceByType(type);
		listWindow.getMyList().setListData(newDatabase.toArray());
		listWindow.getPriceDoc().setDocumentFilter(new DigitFilter());
		LOGGER.info("window " + "\"" + type + "\" open");
	}
}
