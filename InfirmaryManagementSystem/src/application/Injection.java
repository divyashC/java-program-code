package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Injection {

	private DoubleProperty injectionQuantity;
	private StringProperty injectionName, injectionExpiryDate;

	//Default Constructor
	public Injection() {

		this.injectionName = new SimpleStringProperty();
		this.injectionQuantity = new SimpleDoubleProperty();
		this.injectionExpiryDate = new SimpleStringProperty();

	}
	
	//Getters and Setters
	public String getInjectionName() {
		return injectionName.get();
	}

	public void setInjectionName(String injectionName) {
		this.injectionName.set(injectionName);
	}

	public StringProperty get_InjectionName() {
		return injectionName;
	}

	public Double getInjectionQuantity() {
		return injectionQuantity.get();
	}

	public void setInjectionQuantity(Double injectionQuantity) {
		this.injectionQuantity.set(injectionQuantity);
	}

	public DoubleProperty get_InjectionQuantity() {
		return injectionQuantity;
	}

	public String getInjectionExpiryDate() {
		return injectionExpiryDate.get();
	}

	public void setInjectionExpiryDate(String injectionExpiryDate) {
		this.injectionExpiryDate.set(injectionExpiryDate);
	}

	public StringProperty get_InjectionExpiryDate() {
		return injectionExpiryDate;
	}

}
