import java.io.IOException;
import org.apache.log4j.Logger;
import controller.AddComputerDevice;
import controller.BackWindowController;
import controller.DeleteComputerDevice;
import controller.EditComputerDevice;
import controller.MyListSelectionListener;
import controller.OpenNewWindowController;
import controller.ReadController;
import controller.SaveController;
import model.Database;
import view.ListWindow;
import view.Window;

public class Run {

	private final static Logger LOGGER = Logger.getLogger(Run.class);

	public static void main(String[] args) throws IOException {

		Window window = new Window();
		LOGGER.info("new window created");

		ListWindow listWindow = new ListWindow();
		LOGGER.info("new listWindow created");

		OpenNewWindowController openController = new OpenNewWindowController();
		BackWindowController backController = new BackWindowController();
		SaveController saveController = new SaveController();
		ReadController readController = new ReadController();

		AddComputerDevice addDevice = new AddComputerDevice();
		DeleteComputerDevice deleteDevice = new DeleteComputerDevice();
		EditComputerDevice editDevice = new EditComputerDevice();
		MyListSelectionListener myListSelectionListener = new MyListSelectionListener();

		window.setOpenController(openController);
		window.setReadController(readController);

		Database generalDB = new Database();

		readController.setWindow(window);
		readController.setDatabase(generalDB);

		listWindow.setDatabase(generalDB);
		listWindow.setBackWindowController(backController);
		listWindow.setSaveController(saveController);
		listWindow.setAddDevice(addDevice);
		listWindow.setDeleteDevice(deleteDevice);
		listWindow.setEditDevice(editDevice);
		listWindow.setMyListSelectionListener(myListSelectionListener);

		openController.setWindow(window);
		openController.setListWindow(listWindow);
		openController.setDatabase(generalDB);

		saveController.setListWindow(listWindow);
		saveController.setDatabase(generalDB);

		addDevice.setListWindow(listWindow);
		addDevice.setDatabase(generalDB);

		deleteDevice.setListWindow(listWindow);
		deleteDevice.setDatabase(generalDB);

		editDevice.setListWindow(listWindow);
		editDevice.setDatabase(generalDB);

		backController.setListWindow(listWindow);
		backController.setWindow(window);

		myListSelectionListener.setListWindow(listWindow);
		myListSelectionListener.setDatabase(generalDB);

	}
}
