package firrst;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import vPages.MapPage;
import vPages.UCLoginPage;
import vTest.MapTest;

public class firstAPp {

	protected Shell shell;
	MapTest testMap;
	WebDriver driver;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			firstAPp window = new firstAPp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	UCLoginPage loginUC;
	MapPage Map;
	
	@Test()
	public void login() {
		loginUC = new UCLoginPage(driver);
		Map = new MapPage(driver);
		loginUC.LoginUC("admin", "123456");
		
		Map.CreateMapEditor("Source XML TestAuto","Target XML TestAuto", "Test Map Editor");
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 492);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.add("Run Full Recipe");
		combo.add("Create Map");
		combo.add("SOAP");
		combo.add("HTTP");
		combo.setBounds(167, 58, 163, 23);
		
		Label lblNewLabel = new Label(shell, SWT.CENTER);
		lblNewLabel.setBounds(75, 61, 69, 15);
		lblNewLabel.setText("HTTP/SOAP :");
		
		Button btnRun = new Button(shell, SWT.NONE);
		btnRun.setBounds(167, 114, 75, 25);
		btnRun.setText("Run");

	}
}
