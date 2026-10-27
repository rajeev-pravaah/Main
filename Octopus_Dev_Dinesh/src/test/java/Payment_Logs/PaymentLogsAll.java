package Payment_Logs;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.ObjectRepository.Payment_Logs;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class PaymentLogsAll extends BaseClassForGEneratorContacts{
	Payment_Logs pl ;
	@Test
	public void PaymentLogs() {
		pl = new Payment_Logs(driver);
		pl.getBilling().click();
		System.out.println("Payment Logs is clicked");
	
		
	}

}
